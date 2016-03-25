package com.techelevator.campres;

import java.time.LocalDate;
import java.util.List;

public interface SiteSearchDAO {

	public List<Site> showAvailableSites(long siteId, String beginDate, String endDate);
	
}
