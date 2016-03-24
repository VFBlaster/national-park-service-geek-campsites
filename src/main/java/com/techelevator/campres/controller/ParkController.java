package com.techelevator.campres.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.campres.Campsite;
import com.techelevator.campres.Park;
import com.techelevator.campres.ParkCampsiteDAO;
import com.techelevator.campres.ParkListDAO;



@Controller
public class ParkController {
	
	private ParkListDAO parkListDAO;
	private ParkCampsiteDAO parkCampSiteDAO;
	
	@Autowired
	public ParkController(ParkListDAO parkListDAO) {
		this.parkListDAO = parkListDAO;
	}

	@RequestMapping(path = { "/", "/parkList" }, method=RequestMethod.GET)
	public String displayMainPage(Map<String, Object> modelParkList) {
		
		List<Park> parkList = parkListDAO.readAllParks();
		modelParkList.put("parkList", parkList);
		
		return "parkList";
	}
		
	@RequestMapping(path ="/parkCampsites", method=RequestMethod.GET)
	public String displayCampsites(Map<String, Object> modelCampsiteList) {
		
		
		
		List<Campsite> parkCampSiteList = parkCampSiteDAO.readAllCampsites();
		modelCampsiteList.put("parkCampSiteList", parkCampSiteList);
		
		return "parkCampsites"; 
		
	}
		
		
		
		
		

	
}
