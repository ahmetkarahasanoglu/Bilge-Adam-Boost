package com.ahmet.repository.entity;

import java.util.List;

public class Kitap extends BaseEntity {

	String ad;
	List<String> yazar;
	String yayinEvi;
	int sayfaSayisi;
	double kiralamaFiyati;	
	
	// CONSTRUCTOR 1:
	public Kitap() {
		super();
	}

	// CONSTRUCTOR 2:
	public Kitap(String ad, List<String> yazar, String yayinEvi, int sayfaSayisi, double kiralamaFiyati) {
		super();
		this.ad = ad;
		this.yazar = yazar;
		this.yayinEvi = yayinEvi;
		this.sayfaSayisi = sayfaSayisi;
		this.kiralamaFiyati = kiralamaFiyati;
	}

	// GETTERS AND SETTERS:
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public List<String> getYazar() {
		return yazar;
	}

	public void setYazar(List<String> yazar) {
		this.yazar = yazar;
	}

	public String getYayinEvi() {
		return yayinEvi;
	}

	public void setYayinEvi(String yayinEvi) {
		this.yayinEvi = yayinEvi;
	}

	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	public double getKiralamaFiyati() {
		return kiralamaFiyati;
	}

	public void setKiralamaFiyati(double kiralamaFiyati) {
		this.kiralamaFiyati = kiralamaFiyati;
	}

	
	@Override
	public String toString() {
		return "Kitap [ad=" + ad + ", yazar=" + yazar + ", yayinEvi=" + yayinEvi + ", sayfaSayisi=" + sayfaSayisi
				+ ", kiralamaFiyati=" + kiralamaFiyati + "]";
	}
	
	
	
}
