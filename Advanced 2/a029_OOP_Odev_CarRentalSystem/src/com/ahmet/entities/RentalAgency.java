package com.ahmet.entities;

public class RentalAgency extends Entity {
	private String branchName;
	private String location;
	
	// Default Constructor:
	public RentalAgency () {		
		super();
	}
	
	// Constructor with Parameters:
	public RentalAgency(String branchName, String location) {
		super();
		this.branchName = branchName;
		this.location = location;
	}
	// Getters and Setters:
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
