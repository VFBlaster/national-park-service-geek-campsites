package com.techelevator.campres.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.campres.Campsite;
import com.techelevator.campres.Park;
import com.techelevator.campres.ParkCampsiteDAO;
import com.techelevator.campres.ParkListDAO;



@Controller
public class ParkController {
	
	private ParkListDAO parkListDAO;
	private ParkCampsiteDAO parkCampSiteDAO;
	
	@Autowired
	public ParkController(ParkListDAO parkListDAO, ParkCampsiteDAO parkCampSiteDAO) {
		this.parkListDAO = parkListDAO;
		this.parkCampSiteDAO = parkCampSiteDAO;
	}

	@RequestMapping(path = { "/", "/parkList" }, method=RequestMethod.GET)
	public String displayMainPage(Map<String, Object> modelParkList) {
		
		List<Park> parkList = parkListDAO.readAllParks();
		modelParkList.put("parkList", parkList);
		
		return "parkList";
	}
		
	@RequestMapping(path ="/parkCampsites", method=RequestMethod.GET)
	public String displayCampsites(Map<String, Object> modelCampsiteList,
									@RequestParam long parkId) {
		
		Park selectedPark = parkListDAO.findParkByCode(parkId);
		List<Campsite> parkCampSiteList = parkCampSiteDAO.showCampsites(parkId);
		
		System.out.println(parkId);
		
		modelCampsiteList.put("parkCampSiteList", parkCampSiteList);
		modelCampsiteList.put("selectedPark", selectedPark);
		
		System.out.println(parkId);
		
		return "parkCampsites"; 
		
	}
		
	@RequestMapping(path ="/campsite_search", method=RequestMethod.GET)
	public String searchFormCampground(@RequestParam(name="campgroundId") long campgroundId) {
		
		
		
		return "campsite_search";
	}
}

	

