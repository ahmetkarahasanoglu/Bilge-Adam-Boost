package com.ahmet.utility;
/*
 * 2.Yöntem: bir değere karşılık gelen iki parametre tanımlarız.
 * İlk parametre görünen kısmı, ikinci parametre alacağı değeri
 * ifade eder. Böylece kullanımda performans sağlar. Gereksiz
 * bellek kaplama olmaz.
 */
public enum Unvan2 {
	Hizmetli("Hizmetli", 1),
	Personel("Personel", 2),
	KidemliPersonel("KıdemliPersonel", 3),
	Mudur("Müdür", 4),
	GenelMudur("Genel Müdür", 5),
	Muhendis("Mühendis", 6),
	TeknikPersonel("Teknik Personel", 7);
	
	String ad;
	int no;
	
	// Constructor:
	Unvan2(String ad, int no) {
		this.ad = ad;
		this.no = no;
	}
	
	// Getters & Setters:
	public String getAd() {
		return ad;
	}
	public int getNo() {
		return no;
	}
	
	
}
