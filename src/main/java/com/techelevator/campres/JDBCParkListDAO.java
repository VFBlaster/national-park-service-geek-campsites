package com.techelevator.campres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCParkListDAO implements ParkListDAO {

	private JdbcTemplate jdbcTemplate;
	private List<Park> parkList;
	
	@Autowired
	public JDBCParkListDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public List<Park> readAllParks() {
		parkList = new ArrayList<>();
		
		String sqlAllParks = 	"SELECT * " +
								"FROM park";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllParks);
		
		while(results.next()) {
			Park aPark = new Park();
			int park_id = results.getInt("park_id");
			String name = results.getString("name");
			String location = results.getString("location");
			String establish_date = (results.getString("establish_date"));
				LocalDate ld = LocalDate.parse(establish_date);
			Long area = results.getLong("area");
			Long visitors = results.getLong("visitors");
			String description = results.getString("description");
			
			aPark.setPark_id(park_id);
			aPark.setName(name);
			aPark.setLocation(location);
			aPark.setEstablish_date(ld);
			aPark.setArea(area);
			aPark.setVisitors(visitors);
			aPark.setDescription(description);
			
			parkList.add(aPark);
			
		}
		
		return parkList;
	}

}
