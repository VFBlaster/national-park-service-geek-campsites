package com.techelevator.campres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JDBCParkCampsiteDAO implements ParkCampsiteDAO {

	private JdbcTemplate jdbcTemplate;
	private List<Campsite> campsiteList;
	
	@Autowired
	public JDBCParkCampsiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campsite> showCampsites(long parkId) {
		campsiteList = new ArrayList<>();
		
		String sqlAllCampsites = "SELECT * " +
								 "FROM campground " +
								 "WHERE park_id = ?";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCampsites, parkId);
		
		while(results.next()) {
			Campsite campsite = new Campsite();
			
			long campId = results.getLong("campground_id");
			long park_Id = results.getLong("park_id");
			String name = results.getString("name");
			long openFrom = results.getLong("open_from_mm");
			long openTo = results.getLong("open_to_mm");
			BigDecimal dailyFee = results.getBigDecimal("daily_fee");
			
			String sqlSiteNumber = "SELECT count(*) AS countSites " +
					 "FROM site " +
					 "WHERE campground_id = ?";
			SqlRowSet resultSites = jdbcTemplate.queryForRowSet(sqlSiteNumber, campId);
			resultSites.next();
			int site_number = resultSites.getInt("countSites");
			
			campsite.setCampgroundId(campId);
			campsite.setParkId(park_Id);
			campsite.setName(name);
			campsite.setOpenFrom(openFrom);
			campsite.setOpenTo(openTo);
			campsite.setDailyFee(dailyFee);
			campsite.setSite_number(site_number);
			
			campsiteList.add(campsite);
		}
		return campsiteList;
	}
	
	@Override
	public Campsite showCampsgroundName(long campgroundId) {
		Campsite campGround = new Campsite();
		
		String sqlAllCampsites = "SELECT * " +
								 "FROM campground " +
								 "WHERE campground_id = ?";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCampsites, campgroundId);
		results.next();
		long campId = results.getLong("campground_id");
		String name = results.getString("name");

		campGround.setCampgroundId(campId);
		campGround.setName(name);

		return campGround;
	}
	
	
	
	
	
	
	
	
	
}
