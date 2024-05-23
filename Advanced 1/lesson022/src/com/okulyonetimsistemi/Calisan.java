package com.okulyonetimsistemi;

public class Calisan extends Kisi {
	
	private String sicilNo;
	private int calismaSaati;
	private double maas;
	
	
	// CONSTRUCTOR 1:	
	public Calisan(String isim, String soyisim) {
		super(isim, soyisim);		
	}
	
	// CONSTRUCTOR 2:
	public Calisan(String isim, String soyisim, double maas, int calismaSaati) {
		super(isim, soyisim);
		this.maas = maas;
		this.calismaSaati = calismaSaati;
	}

	// GETTERS AND SETTERS:
	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

	public int getCalismaSaati() {
		return calismaSaati;
	}

	public void setCalismaSaati(int calismaSaati) {
		this.calismaSaati = calismaSaati;
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}

	@Override
	public void menu() {
		super.menu();
	}
	
	
	
	
	
	
	
}
