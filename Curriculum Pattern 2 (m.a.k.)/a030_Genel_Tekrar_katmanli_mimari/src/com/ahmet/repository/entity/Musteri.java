package com.ahmet.repository.entity;

import java.util.Random;

public class Musteri extends BaseEntity {
	private Long id;
	private String ad;
	private String soyad;
	private String adres;
	private String telefon;
	private String dogumtarihi;
	private int puan;	

	// --- CONSTRUCTOR (Default): ---
	public Musteri() {
		super(System.currentTimeMillis(), System.currentTimeMillis(), 1);
		this.id = new Random().nextLong();
	}
	
	// --- CONSTRUCTOR  ---
	public Musteri(String ad, String soyad, String adres, String telefon, String dogumtarihi, int puan) {
		super(System.currentTimeMillis(), System.currentTimeMillis(), 1);
		this.id = new Random().nextLong(); // rastgele sayıları ID olarak kullancaz (büyük sayılar bunlar)
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
		this.telefon = telefon;
		this.dogumtarihi = dogumtarihi;
		this.puan = puan;
	}
	// --- GETTERS & SETTERS ---
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getDogumtarihi() {
		return dogumtarihi;
	}
	public void setDogumtarihi(String dogumtarihi) {
		this.dogumtarihi = dogumtarihi;
	}
	public int getPuan() {
		return puan;
	}// 'setPuan' metodunu sildik; onun yerine aşağıda 'puanArttir' ve 'puanSifirla' metotlarımız var.
	
	
	// --- METOTLAR: ---
	public void puanArttir() {
		this.puan++;
	}
	public void puanSifirla() {
		this.puan = 0;
	}
	
	
}
