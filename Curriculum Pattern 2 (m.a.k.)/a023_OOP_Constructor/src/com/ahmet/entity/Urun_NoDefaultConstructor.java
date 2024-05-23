package com.ahmet.entity;

import java.util.Random;

public class Urun_NoDefaultConstructor {
		
	public long id;
	public String ad;
	public double fiyat;

	/*
	 *  Default Constructor'ı iptal etmek: default constructor'ı
	 *  yazmadan, parametreli bir constructor oluşturmak yeterlidir.
	 *  (Bu şekilde; kod yazan kişiye yeni ürün oluştururken 
	 *  parametre girmeyi zorunlu hâle getiriyoruz.
	 */
	public Urun_NoDefaultConstructor (String urunAdi, double urunFiyati) {
		id = new Random().nextLong();
		ad = urunAdi;
		fiyat = urunFiyati;
	}
}
