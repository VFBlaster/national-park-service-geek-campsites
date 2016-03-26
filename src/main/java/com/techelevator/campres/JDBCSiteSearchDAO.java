package com.techelevator.campres;

import java.time.LocalDate;
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
	private List<Reservation> resList;
	private List<Site> availableSiteList;

	@Autowired
	public JDBCSiteSearchDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	@Override
	public List<Site> showAvailableSites(long campgroundId, String beginDate, String endDate) {
		
		resList  = new ArrayList<>();
		availableSiteList = new ArrayList<>();
	
		String sqlAllReservations = "SELECT * " +
									"FROM site " +
									"LEFT JOIN reservation ON site.site_id = reservation.site_id " +
									"WHERE site.campground_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllReservations, campgroundId);
		
		while(results.next()) {
						
				long reservation_id = results.getLong("reservation_id");
			
				if (reservation_id == 0) {
					Site availableSite = new Site();
					
					long site_id = results.getLong("site_id");
					long campground_id = results.getLong("campground_id");
					long site_number = results.getLong("site_number");
					long max_occupancy = results.getLong("max_occupancy");
					boolean accessible = results.getBoolean("accessible");
					long max_rv_length = results.getLong("max_rv_length");
					boolean utilities = results.getBoolean("utilities");

					availableSite.setSite_id(site_id);
					availableSite.setCampground_id(campground_id);
					availableSite.setSite_number(site_number);
					availableSite.setMax_occupancy(max_occupancy);
					availableSite.setAccessible(accessible);
					availableSite.setMax_rv_length(max_rv_length);
					availableSite.setUtilities(utilities);
					
					System.out.println("added Sites to List, .... sucker");
					
					availableSiteList.add(availableSite);
				
			} else {
			
				Reservation res = new Reservation();
				
					long site_id = results.getLong("site_id");
					String name = results.getString("name");
					String from_date = results.getString("from_date");
						LocalDate fromLD = LocalDate.parse(from_date);
					String to_date = results.getString("to_date");
						LocalDate toLD = LocalDate.parse(to_date);
					String create_date = results.getString("create_date");
					LocalDate create_dateLD = LocalDate.parse(create_date);
					
					res.setReservation_id(reservation_id);
					res.setSite_id(site_id);
					res.setName(name);
					res.setFrom_date(fromLD);
					res.setTo_date(toLD);
					res.setTo_date(create_dateLD);
				
					resList.add(res);
					
		
		boolean isSiteAvailable;
		
		for(Reservation r : resList) {
			LocalDate fd = r.getFrom_date();
			LocalDate td = r.getTo_date();
			LocalDate beginDateLD = LocalDate.parse(beginDate);
			LocalDate endDateLD = LocalDate.parse(endDate);
			
			if (fd.isAfter(beginDateLD) && fd.isBefore(endDateLD)){
				isSiteAvailable = false;
				System.out.println("1its false, .... sucker");

			}
			else if (td.isAfter(beginDateLD) && td.isBefore(endDateLD)){
				isSiteAvailable = false;
				System.out.println("2its false, .... sucker");

			}
			else if (fd.isBefore(beginDateLD) && td.isAfter(endDateLD)) {
				isSiteAvailable = false;
				System.out.println("3its false, .... sucker");

			}
			else {
				isSiteAvailable = true;
				
				Site availableSite = new Site();
						
				long siteId = results.getLong("site_id");
				long campground_id = results.getLong("campground_id");
				long site_number = results.getLong("site_number");
				long max_occupancy = results.getLong("max_occupancy");
				boolean accessible = results.getBoolean("accessible");
				long max_rv_length = results.getLong("max_rv_length");
				boolean utilities = results.getBoolean("utilities");

				availableSite.setSite_id(siteId);
				availableSite.setCampground_id(campground_id);
				availableSite.setSite_number(site_number);
				availableSite.setMax_occupancy(max_occupancy);
				availableSite.setAccessible(accessible);
				availableSite.setMax_rv_length(max_rv_length);
				availableSite.setUtilities(utilities);
				
				System.out.println("4its true, .... sucker");
				
				availableSiteList.add(availableSite);
			}
			}
		}
		}
	
		return availableSiteList;

	}
	
}






