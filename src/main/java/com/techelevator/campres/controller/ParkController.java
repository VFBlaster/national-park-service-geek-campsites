package com.techelevator.campres.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.campres.Campsite;
import com.techelevator.campres.Park;
import com.techelevator.campres.ParkCampsiteDAO;
import com.techelevator.campres.ParkListDAO;
import com.techelevator.campres.Site;
import com.techelevator.campres.SiteSearchDAO;



@Controller
@Transactional
public class ParkController {
	
	private ParkListDAO parkListDAO;
	private ParkCampsiteDAO parkCampSiteDAO;
	private SiteSearchDAO siteSearchDAO;
	
	@Autowired
	public ParkController(ParkListDAO parkListDAO, ParkCampsiteDAO parkCampSiteDAO, SiteSearchDAO siteSearchDAO) {
		this.parkListDAO = parkListDAO;
		this.parkCampSiteDAO = parkCampSiteDAO;
		this.siteSearchDAO = siteSearchDAO;
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
				
		modelCampsiteList.put("parkCampSiteList", parkCampSiteList);
		modelCampsiteList.put("selectedPark", selectedPark);
				
		return "parkCampsites"; 
		
	}
		
	@RequestMapping(path ="/campsite_search", method=RequestMethod.GET)
	public String searchFormCampground(Map<String, Object> modelCampground,
										@RequestParam(name="campgroundId") long campgroundId) {
		
		Campsite parkCampGround = parkCampSiteDAO.showCampsgroundName(campgroundId);
		modelCampground.put("parkCampGround", parkCampGround);

		return "campsite_search";
	}
	
	
	@RequestMapping(path = "/siteSearchResults", method=RequestMethod.GET)
	public String getSearchResults(Map<String, Object> modelSiteSearchResults,
													   	@RequestParam(name="campgroundId") long campgroundId, 
														@RequestParam(name="begindate") String beginDate,
														@RequestParam(name="enddate") String endDate){
		
		List<Site> sites = siteSearchDAO.showAvailableSites(campgroundId, beginDate, endDate);
	
		modelSiteSearchResults.put("sites", sites);
		modelSiteSearchResults.put("begin", beginDate);
		modelSiteSearchResults.put("end", endDate);


		return "siteSearchResults";												
		
	}
}

	

