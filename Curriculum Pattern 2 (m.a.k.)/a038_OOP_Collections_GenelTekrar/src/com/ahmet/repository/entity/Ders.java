package com.ahmet.repository.entity;

public class Ders extends BaseEntity {

	String ad;

	
	// CONSTRUCTOR:
	public Ders(String ad) {
		super();
		this.ad = ad;
	}

	// GETTERS AND SETTERS:
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
	
	
}
