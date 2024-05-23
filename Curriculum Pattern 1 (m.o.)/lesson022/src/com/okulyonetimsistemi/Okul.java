package com.okulyonetimsistemi;

import java.util.ArrayList;

public class Okul {

	private String isim;
	private String adres;
	public final static ArrayList<Ogrenci> ogrenciListesi = new ArrayList<Ogrenci>();  // final yaptık -> array'in içini değiştirebiliriz (eleman ekleyebiliriz), ama referansını değiştiremeyiz (tekrar new'leyemeyiz; veya başka bir arrayList'i buna atayamayız.).
	public final static ArrayList<Ogretmen> ogretmenListesi = new ArrayList<Ogretmen>(); // '--> final değişkenler için: Primitive tiplerde içeriğini değiştiremeyiz, Referans tiplerde referansını değiştiremeyiz (↑).	
	public final static ArrayList<Memur> memurListesi = new ArrayList<Memur>();
	
	
	// CONSTRUCTOR:
	public Okul(String isim, String adres) {
		super();
		this.isim = isim;
		this.adres = adres;			
	}

	// --- GETTERS AND SETTERS: ---
	public String getIsim() {
		return isim;
	}


	public void setIsim(String isim) {
		this.isim = isim;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	
	
	
}
