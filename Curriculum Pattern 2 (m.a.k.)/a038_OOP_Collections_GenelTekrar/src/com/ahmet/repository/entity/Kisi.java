package com.ahmet.repository.entity;

public class Kisi extends BaseEntity {

	String ad;
	String soyad;
	String adres;
	String telefon;
	int yas;
	ECinsiyet cinsiyet;
	
	
	public Kisi() {
		
	}

	// CONSTRUCTOR:
	public Kisi(String ad, String soyad, String adres, String telefon, int yas, ECinsiyet cinsiyet) {
		super();		
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
		this.telefon = telefon;
		this.yas = yas;
		this.cinsiyet = cinsiyet;
	}

	// GETTERS AND SETTERS:

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public ECinsiyet getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(ECinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	// METHODS: ----------------------
	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", adres=" + adres + ", telefon=" + telefon
				+ ", yas=" + yas + ", cinsiyet=" + cinsiyet + "]";
	}
	
	
	
	
}
