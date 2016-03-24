package com.techelevator.campres;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkCampsiteDAO implements ParkCampsiteDAO {

	private JdbcTemplate jdbcTemplate;
	private List<Campsite> campsiteList;
	
	@Autowired
	public JDBCParkCampsiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campsite> showCampsites(Long parkId) {
		campsiteList = new ArrayList<>();
		
		String sqlAllCampsites = "SELECT * " +
								 "FROM campground " +
								 "WHERE park_id = ?";
		
		//String currentParkId = Long.toString(parkId);
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCampsites, parkId);
								 
		while(results.next()) {
			
			Campsite campsite = new Campsite();
			
			Long campId = results.getLong("campground_id");
			Long park_Id = results.getLong("park_id");
			String name = results.getString("name");
			Long openFrom = results.getLong("open_from_mm");
			Long openTo = results.getLong("open_to_mm");
			Long dailyFee = results.getLong("daily_fee");
			
			campsite.setCampgroundId(campId);
			campsite.setParkId(park_Id);
			campsite.setName(name);
			campsite.setOpenFrom(openFrom);
			campsite.setOpenTo(openTo);
			campsite.setDailyFee(dailyFee);
			
			campsiteList.add(campsite);
		}
		return campsiteList;
			
	}	
}
