package com.ahmet.entities;

public class RentalContract extends Entity {	
	private int rentalDuration;
	private double rentalPrice;
	private String paymentMethod;
	
	private Customer customer;
	private Car car;
	
	// Default Constructor:
	public RentalContract() {
	super();
	}
	
	// Constructor with Parameters:
	public RentalContract(int rentalDuration, double rentalPrice, String paymentMethod,
			Customer customer, Car car) {
		super();
		this.rentalDuration = rentalDuration;
		this.rentalPrice = rentalPrice;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		this.car = car;
	}
	// Getters and Setters:
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
