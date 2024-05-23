package com.ahmet.repository.entity;

import java.util.Random;

public class Urun {
	
	// POJO -> Plain Old Javascript Object (object from simple classes that has constructor and getters & setters)
	
	private Long id;
	private String ad;
	private String marka;
	private String model;
	private Double alisfiyati;
	private Double satisfiyati;
	private int stokmiktari;
	private int kdvorani;
	
	// --- CONSTRUCTOR ---
	public Urun(String ad, String marka, String model, Double alisfiyati, Double satisfiyati, int stokmiktari,
			int kdvorani) {
		super();
		this.id = new Random().nextLong();
		this.ad = ad;
		this.marka = marka;
		this.model = model;
		this.alisfiyati = alisfiyati;
		this.satisfiyati = satisfiyati;
		this.stokmiktari = stokmiktari;
		this.kdvorani = kdvorani;
	}
	
	// --- GETTERS & SETTERS ---
	public Long getId() {
		return id;
	}
	
//	public void setId(Long id) {   // Id değiştirilemesin diye 'set' metodunu kapattım.
//		this.id = id;
//	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getAlisfiyati() {
		return alisfiyati;
	}
	public void setAlisfiyati(Double alisfiyati) {
		this.alisfiyati = alisfiyati;
	}
	public Double getSatisfiyati() {
		return satisfiyati;
	}
	public void setSatisfiyati(Double satisfiyati) {
		this.satisfiyati = satisfiyati;
	}
	public int getStokmiktari() {
		return stokmiktari;
	}
	public void setStokmiktari(int stokmiktari) {
		this.stokmiktari = stokmiktari;
	}
	public int getKdvorani() {
		return kdvorani;
	}
	public void setKdvorani(int kdvorani) {
		this.kdvorani = kdvorani;
	}
	
	
	
}


