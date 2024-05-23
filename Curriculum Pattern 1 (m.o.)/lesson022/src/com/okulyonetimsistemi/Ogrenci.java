package com.okulyonetimsistemi;

import java.util.ArrayList;

public class Ogrenci extends Kisi {

	private String okulNo;
	private static int index;
	double notOrt;
	ArrayList<Ders> dersListesi;
	
	
	// CONSTRUCTOR 1:
	public Ogrenci(String isim, String soyisim) {
		super(isim, soyisim);
		this.dersListesi = new ArrayList<>(); // Ogrenci class'ından nesne oluşur oluşmaz bu ArrayList'i oluşturmuş oluruz bu yöntemle.
		okulNoAta();
	}
	
	// CONSTRUCTOR 2:
	public Ogrenci(String isim, String soyisim, String adres) {
		super(isim, soyisim, adres);
		this.dersListesi = new ArrayList<>();
		okulNoAta();
	}

	
	// --- GETTERS AND SETTERS: ---
	public String getOkulNo() {
		return okulNo;
	}

	public void setOkulNo(String okulNo) {
		this.okulNo = okulNo;
	}

	public double getNotOrt() {
		return notOrt;
	}

	public void setNotOrt(double notOrt) {
		this.notOrt = notOrt;
	}

	public ArrayList<Ders> getDersListesi() {
		return dersListesi;
	}

	public void setDersListesi(ArrayList<Ders> dersListesi) {
		this.dersListesi = dersListesi;
	}
	
	
	// --- METHODS: ---
	public void okulNoAta() {
		index++;
		this.okulNo = "Ö-" + index;
	}
	
	@Override
	public void menu() {		
		super.menu();
		System.out.println("*** Öğrenci İşlemleri ***");
		System.out.println("1- Ders kaydı");
		System.out.println("2- Not ortalaması görüntüle");
		System.out.println("3- Aldığım dersleri listele");
	}

	@Override
	public String toString() {  // Right click -> Source -> Generate toString()
		return "Ogrenci [okulNo=" + okulNo + ", notOrt=" + notOrt + ", getIsim()=" + getIsim() + ", getSoyisim()="
				+ getSoyisim() + "]";
	}
	
	
	
	
	
}
