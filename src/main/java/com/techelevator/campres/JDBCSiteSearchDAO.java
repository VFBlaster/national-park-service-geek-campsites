package com.techelevator.campres;

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
public class JDBCSiteSearchDAO implements SiteSearchDAO {

	private JdbcTemplate jdbcTemplate;
	private List<Site> siteList;

	@Autowired
	public JDBCSiteSearchDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	@Override
	public List<Site> showSites(long siteId) {
		
		siteList  = new ArrayList<>();
	
		String sqlAllSites = "SELECT * " +
							 "FROM site " +
							 "LIMIT 10";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllSites);
		
		while(results.next()) {
			Site site = new Site();
			
		long site_id = results.getLong("site_id");
		long campgroundId = results.getLong("campground_id");
		long siteNumber = results.getLong("site_number");
		long maxOccupancy = results.getLong("max_occupancy");
		boolean accessible = results.getBoolean("accessible");
		long maxRvLength = results.getLong("max_rv_length");
		boolean utilities = results.getBoolean("utilities");
		
		site.setSite_id(site_id);
		site.setCampground_id(campgroundId);
		site.setSite_number(siteNumber);
		site.setMax_occupancy(maxOccupancy);
		site.setAccessible(accessible);
		site.setMax_rv_length(maxRvLength);
		site.setUtilities(utilities);
		
		siteList.add(site);
		}
		return siteList;

		
	
	}
	
	
		
		
}

