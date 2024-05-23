package com.okulyonetimsistemi;

import java.util.ArrayList;

public class Ders {
	
	private int kontenjan;
	private String isim;
	private ArrayList<Ogretmen> ogretmenListesi;
	private ArrayList<Ogrenci> ogrenciListesi;
	
	
	// CONSTRUCTOR:	
	public Ders(int kontenjan, String isim) {
		super();
		this.kontenjan = kontenjan;
		this.isim = isim;
		this.ogrenciListesi = new ArrayList<>(); // constructor'da new'ledik ArrayList'leri
		this.ogretmenListesi = new ArrayList<>();
	}

	// GETTERS AND SETTERS: 
	public int getKontenjan() {
		return kontenjan;
	}

	public void setKontenjan(int kontenjan) {
		this.kontenjan = kontenjan;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public ArrayList<Ogretmen> getOgretmenListesi() {
		return ogretmenListesi;
	}

	public void setOgretmenListesi(ArrayList<Ogretmen> ogretmenListesi) {
		this.ogretmenListesi = ogretmenListesi;
	}

	public ArrayList<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}

	public void setOgrenciListesi(ArrayList<Ogrenci> ogrenciListesi) {
		this.ogrenciListesi = ogrenciListesi;
	}
	
	
	
	
	
	
}
