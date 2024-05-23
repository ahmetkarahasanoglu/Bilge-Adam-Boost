package com.ahmet.entity;

import java.util.Date;

public class Hasta {

	// long id;  --> değer atamazsanız default değeri 0'dır. 
	Long id; // değer atamazsanız null olur.
	String ad;
	String tcno;
	Date dogumtarihi;
	String adres;
	String[] hastaliklari;
	
	public void randevuAl() {
		System.out.println("Hastaya randevu alındı....: " + new Date());
	}
	
	public void pansumanYap() {
		System.out.println("Ameliyat bölgesi temizlendi, yeni sargılar sarıldı.");
	}
	
	public void pansumanYap(String goz) {
		System.out.println("hastanın " + goz + " pansumanı yapıldı.");
	}
	
}
