package com.ahmet.entity;

public class Personel {

	public String ad;
	public String adres;
	public String telefon;
	public String isegiristarihi;
	
	public Personel() {
//		ad = ""; 
	}
	
	// Parametreli Constructor:
	public Personel(String perAdi, String perAdresi, String tlf, String iseGirTar) {
		ad = perAdi;
		adres = perAdresi;
		telefon = tlf;
		isegiristarihi = iseGirTar;
	}
}
