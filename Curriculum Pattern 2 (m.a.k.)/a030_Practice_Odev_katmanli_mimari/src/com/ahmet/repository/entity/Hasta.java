package com.ahmet.repository.entity;

import java.util.Random;

import com.ahmet.utility.StaticValues;

public class Hasta extends BaseEntity {
	
	private long id;
	private int hastaNo;
	private String adiSoyadi;
	private String hastalik;
	
	// CONSTRUCTOR 1:
	public Hasta() {
		super(System.currentTimeMillis(), System.currentTimeMillis(), 1);
		id = new Random().nextLong();
		hastaNo = ++StaticValues.hastaNo;
	}
	
	// CONSTRUCTOR 2:
	public Hasta(String adiSoyadi, String hastalik) {
		super(System.currentTimeMillis(), System.currentTimeMillis(), 1);		
		this.adiSoyadi = adiSoyadi;
		this.hastalik = hastalik;
		id = new Random().nextLong();
		hastaNo = ++StaticValues.hastaNo;
	}

	public long getId() {
		return id;
	}

//	public void setId(long id) {  // kapattım setId metodunu.
//		this.id = id;
//	}

	public int getHastaNo() {
		return hastaNo;
	}

	public void setHastaNo(int hastaNo) {  // kapattım setHastaNo metodunu.
		this.hastaNo = hastaNo;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getHastalik() {
		return hastalik;
	}

	public void setHastalik(String hastalik) {
		this.hastalik = hastalik;
	}
	
	
	
	
	
}
