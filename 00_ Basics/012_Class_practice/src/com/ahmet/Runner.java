package com.ahmet;

public class Runner {

	public static void main(String[] args) {
		
/*
 * Ayşe diye bir öğrenci var;
 * Matematik ve Türkçe dersi var.
 * Notlarını gireceğiz.
 */
		Ders matematik = new Ders();
		matematik.ad = "Matematik";
		matematik.vizeNotu = 56;
		matematik.finalNotu = 91;
		matematik.ortalama = 73.5;
		
		Ders turkce = new Ders();
		turkce.ad = "Türkçe";
		turkce.vizeNotu = 95;
		turkce.finalNotu = 97;
		turkce.ortalama = 96;
		
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.okulNo = "OKL002";
		ogrenci.ad = "Ayşe";
		ogrenci.soyad = "KUŞ";
		ogrenci.adres = "Ankara";
		ogrenci.dersler = new Ders[] {matematik,turkce};
		// the above line is just like the example in below 2 lines:
		int[] numbers;
		numbers = new int[] {3,5,6,7};
		
		System.out.println("Öğrenci adı: " + ogrenci.ad);
		System.out.println("Öğrencinin türkçe dersinin ortalaması: " + ogrenci.dersler[1].ortalama);
		
		
		
		
	}//main ends here

}//class ends here
