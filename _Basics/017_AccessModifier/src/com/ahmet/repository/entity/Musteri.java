package com.ahmet.repository.entity;

import com.ahmet.repository.MusteriRepositoryImpl;

public class Musteri {
	public String ad;
	private String adres;
	protected String soyad;
	String telefon; // if I don't use access modifier at all, it
					// can be accessed from the same package.
					// ex: from Urun.jave (in the same package)
	
	public void islem() {
		adres = "Ankara";
		MusteriRepositoryImpl mr = new MusteriRepositoryImpl();
		mr.neyyy = "asdfasdf";
	}
	
	
}
