package com.techelevator.campres;

import java.time.LocalDate;

public class Park {
	
	private long park_id;
	private String name;
	private String location;
	private LocalDate establish_date;
	private long area;
	private long visitors;
	private String description;
	
	
	
	public long getPark_id() {
		return park_id;
	}
	public void setPark_id(long park_id) {
		this.park_id = park_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEstablish_date() {
		return establish_date;
	}
	public void setEstablish_date(LocalDate establish_date) {
		this.establish_date = establish_date;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	public Long getVisitors() {
		return visitors;
	}
	public void setVisitors(long visitors) {
		this.visitors = visitors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	
	
	
	

}