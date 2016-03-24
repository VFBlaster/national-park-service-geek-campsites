package com.techelevator.campres;

import java.math.BigDecimal;

public class Campsite {

	private long campgroundId;
	private long parkId;
	private String name;
	private long openFrom;
	private long openTo;
	private BigDecimal dailyFee;
	
	
	public Long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getOpenFrom() {
		return openFrom;
	}
	public void setOpenFrom(long openFrom) {
		this.openFrom = openFrom;
	}
	public long getOpenTo() {
		return openTo;
	}
	public void setOpenTo(long openTo) {
		this.openTo = openTo;
	}
	public BigDecimal getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(BigDecimal dailyFee) {
		this.dailyFee = dailyFee;
	}
	
}
