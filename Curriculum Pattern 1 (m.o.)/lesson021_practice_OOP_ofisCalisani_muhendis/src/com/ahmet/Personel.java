package com.ahmet;

public class Personel {
	private String isim;
	private String soyisim;
	private String unvan;
	private double maas;
	
	// Constructor 1:
	public Personel(String isim, String soyisim) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;		
	}

	// Constructor 2:
	public Personel(String isim, String soyisim, double maas) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.maas = maas;
	}

	// Getters and Setters:
	public String getIsim() {
		return isim;
	}

//	public void setIsim(String isim) {  // İsim sonradan değiştirilemesin istedik.
//		this.isim = isim;
//	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	
	public void setUnvan(double maas) { // method overloading (with the above method). Maaşa göre ünvan belirlemek için kullanacaz.
		
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}
	
	// METHODS:
	public double zamYap(double zamYuzdesi) {
		this.maas = this.maas + (this.maas * zamYuzdesi / 100);
		return this.maas;
	}
	

	
}
