package com.techelevator.campres;

import java.time.LocalDate;

public interface ReservationInsertDAO {

	public Reservation insertReservationIntoDatabase(long site_id, String name, LocalDate from_date, LocalDate to_date, LocalDate create_date);
	
}