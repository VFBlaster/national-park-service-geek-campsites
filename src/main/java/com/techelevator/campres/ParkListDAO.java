package com.techelevator.campres;

import java.util.List;


public interface ParkListDAO {

	public List<Park> readAllParks();

	public Park findParkByCode(Long parkId);
	
	
	
}
