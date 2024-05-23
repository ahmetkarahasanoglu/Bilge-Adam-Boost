package com.ahmet.entities;

public class Customer extends Entity {
	private String name;
	private String address;
	private String phoneNumber;
	
	// Default Constructor:
	public Customer() {		
		super();
	}
	
	// Constructor with Parameters:
	public Customer(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	// Getters and Setters:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
