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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.campres.Campsite;
import com.techelevator.campres.Park;
import com.techelevator.campres.ParkCampsiteDAO;
import com.techelevator.campres.ParkListDAO;
import com.techelevator.campres.Reservation;
import com.techelevator.campres.ReservationInsertDAO;
import com.techelevator.campres.Site;
import com.techelevator.campres.SiteSearchDAO;



@Controller
@SessionAttributes({"selectedPark", "beginD", "endD", "campgroundIdFinal", "campgroundNameFinal", "chosenSite", "siteIdReserve", "guestName"})  
@Transactional
public class ParkController {
	
	private ParkListDAO parkListDAO;
	private ParkCampsiteDAO parkCampSiteDAO;
	private SiteSearchDAO siteSearchDAO;
	private ReservationInsertDAO reservationInsertDAO;
	
	@Autowired
	public ParkController(ParkListDAO parkListDAO, ParkCampsiteDAO parkCampSiteDAO, SiteSearchDAO siteSearchDAO, ReservationInsertDAO reservationInsertDAO) {
		this.parkListDAO = parkListDAO;
		this.parkCampSiteDAO = parkCampSiteDAO;
		this.siteSearchDAO = siteSearchDAO;
		this.reservationInsertDAO = reservationInsertDAO;
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
													   	@RequestParam(name="campgroundIdFinal") long campgroundId,
													   	@RequestParam(name="campgroundNameFinal") String campgroundNameFinal,
														@RequestParam(name="begindate") String beginDate,
														@RequestParam(name="enddate") String endDate){
														
		
		List<Site> sites = siteSearchDAO.showAvailableSites(campgroundId, beginDate, endDate);
	
		modelSiteSearchResults.put("sites", sites);
		modelSiteSearchResults.put("begin", beginDate);
		modelSiteSearchResults.put("end", endDate);
		modelSiteSearchResults.put("campgroundIdFinal", campgroundId);
		modelSiteSearchResults.put("campgroundNameFinal", campgroundNameFinal);

		return "siteSearchResults";													
	}
	
	@RequestMapping(path = "/reserve", method=RequestMethod.POST)
	public String reserveSite(Map<String, Object> modelReservation,
								@RequestParam(name="siteIdReserve") long siteId,
								@RequestParam(name="beginD") String beginD,
								@RequestParam(name="endD") String endD,
								@RequestParam(name="utilities") boolean utilities,
								@RequestParam(name="RV") long RV,
								@RequestParam(name="occupancy") long occupancy,
								@RequestParam(name="accessible") boolean accessible){
			
		
		
		Site chosenSite = new Site();
		chosenSite.setUtilities(utilities);
		chosenSite.setMax_rv_length(RV);
		chosenSite.setMax_occupancy(occupancy);
		chosenSite.setAccessible(accessible);
						
		
		modelReservation.put("siteIdReserve", siteId);
		modelReservation.put("beginD", beginD);
		modelReservation.put("endD", endD);
		modelReservation.put("chosenSite", chosenSite);


		return "redirect:/reservationForm";
	}
	
	@RequestMapping(path="/reservationForm", method=RequestMethod.GET)
	public String displayNameEntryForm(){
		
		return "reservationForm";
	}
	
	@RequestMapping(path="/reserveWithName", method=RequestMethod.POST)
	public String nameEntryToReserve(Map<String, Object> modelNameEntry,
									@RequestParam(name="guestName") String guestName,
									@RequestParam(name="siteIdRes") long siteIdRes,
									@RequestParam(name="beginD") String beginD,
									@RequestParam(name="endD") String endD){
		
		LocalDate today = LocalDate.now();
		LocalDate beginLd = LocalDate.parse(beginD);
		LocalDate endLd = LocalDate.parse(endD);

		System.out.println("In controller " + guestName);
		System.out.println(siteIdRes);
		System.out.println(today);
		System.out.println("LD: " + beginLd);
		System.out.println(endLd);
		
		Reservation siteReservation = reservationInsertDAO.insertReservationIntoDatabase(siteIdRes, guestName, beginLd, endLd, today);
		
		modelNameEntry.put("guestName", guestName);
		modelNameEntry.put("siteReservation", siteReservation);
				
		return "redirect:/confirmReservation";
	}
	
	@RequestMapping(path="/confirmReservation", method=RequestMethod.GET)
	public String displayThankyou(){
		
		return "thankyou";
	}
	
	
	
	
}

	

