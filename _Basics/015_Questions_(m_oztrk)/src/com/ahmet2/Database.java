package com.ahmet2;

public class Database {

	static Kullanici[] kullaniciListesi = new Kullanici[5];

	static int uzunluk = 1;

	public static void veriTabaniBaslangicDegerleri() {

		Kullanici kullanici = new Kullanici();
		kullanici.email = "mustafa@gmail.com";
		kullanici.isim = "Mustafa";
		kullanici.password = "123";
		kullanici.id = uzunluk;
		uzunluk++;
		kullaniciListesi[0] = kullanici;
		
		Kullanici kullanici2 = new Kullanici();
		kullanici2.email = "merve@gmail.com";
		kullanici2.isim = "Merve";
		kullanici2.password = "123";
		kullanici2.id = uzunluk;
		kullaniciListesi[1] = kullanici2;
		uzunluk++;
		Kullanici kullanici3 = new Kullanici();
		kullanici3.email = "yasin@gmail.com";
		kullanici3.isim = "Yasin";
		kullanici3.password = "123";
		kullanici3.id = uzunluk;
		kullaniciListesi[2] = kullanici3;
		uzunluk++;
	}

}