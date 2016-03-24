package com.techelevator.campres;

public class Campsite {

	private Long campgroundId;
	private Long parkId;
	private String name;
	private Long openFrom;
	private Long openTo;
	private Long dailyFee;
	
	
	public Long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public Long getParkId() {
		return parkId;
	}
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getOpenFrom() {
		return openFrom;
	}
	public void setOpenFrom(Long openFrom) {
		this.openFrom = openFrom;
	}
	public Long getOpenTo() {
		return openTo;
	}
	public void setOpenTo(Long openTo) {
		this.openTo = openTo;
	}
	public Long getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(Long dailyFee) {
		this.dailyFee = dailyFee;
	}
	
}
