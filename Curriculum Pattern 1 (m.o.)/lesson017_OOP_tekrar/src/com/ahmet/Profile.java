package com.ahmet;

public class Profile {
	// SINIFIMIZIN ÖZELLİĞİ:
	static int id; //'static' -> sınıfa ait bir özellik olduğunu belirtir.
	// NESNE ÖZELLİKLERİMİZ:	
	String profilResmi;
	String[] posts = new String[10];
	int postSayisi = posts.length;
	String username;
	String isim;
	int takipciSayisi;
	int takipSayisi;
	
	// Metotlar:
	public void postOlustur() {
		System.out.println("Post oluştu.");
	}
	public void profiliDuzenle() {
		System.out.println("Profil duzenlendi.");
	}
	
}
