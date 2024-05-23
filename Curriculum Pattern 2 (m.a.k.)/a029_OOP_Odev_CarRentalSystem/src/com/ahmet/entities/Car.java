package com.ahmet.entities;

public class Car extends Entity {
	private String brand;
	private String model;
	private String year;
	
	// Default Constructor:
	public Car() {	
		super();
	}
	
	// Constructor with Parameters:
	public Car(String brand, String model, String year) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	// Getters and Setters:
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	// --- Methods: ---
	public int calculateRentalCost(int day) {
		return day * 500;
	}
	
	public int calculateRentalCost(int day, boolean extraInsurance) {
		if(extraInsurance) {
			return day * (500 + 100);  // '--> Method Overloading
		}else {
			return day * 500;
		}		
	}
	
	@Override
	public void printDetails() {
		System.out.println("ID: " + this.getId());
		System.out.println("UUID: " + this.getUuid());
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Year: " + year);
	}
	
	
	
	
	
}
