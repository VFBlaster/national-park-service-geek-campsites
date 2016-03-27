package com.techelevator.campres;

import java.time.LocalDate;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@Transactional
public class JDBCReservationInsertDAO implements ReservationInsertDAO {

	private JdbcTemplate jdbcTemplate;
	private Reservation reservation;

	@Autowired
	public JDBCReservationInsertDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	
		}
	
	
	@Override
	public Reservation insertReservationIntoDatabase(long site_id, String name, LocalDate from_date,
		LocalDate to_date, LocalDate create_date) {
		
		reservation = new Reservation();

		String sqlNextResId = "SELECT nextval('reservation_reservation_id_seq')";
		SqlRowSet resultID = jdbcTemplate.queryForRowSet(sqlNextResId);
		resultID.next();
		int nextResID = resultID.getInt(1);
		
		String sqlReservation = "INSERT INTO reservation (reservation_id, site_id, name, from_date, to_date, create_date) " +
								"VALUES (?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sqlReservation, nextResID, site_id, name, from_date, to_date, create_date);
		
		reservation.setReservation_id((long)(nextResID));
		reservation.setSite_id((long)(site_id));
		reservation.setName(name);
		reservation.setFrom_date(from_date);
		reservation.setTo_date(to_date);
		reservation.setCreate_date(create_date);
		
		return reservation;

	}

}
