package com.ahmet;

import com.ahmet.entity.Araba;

public class Runner_OOPnin_Kolayligi {

	public static void main(String[] args) {
/*
 * *** OBJECT ORIENTED PROGRAMMING ***
 * ---------
 * Soyutlama: Bir nesneye ait onu var eden temel özelliklerin tümü
 * 			  ile yapılır.
 */
/*
 * 
 *  --- OOP KULLANMADAN NE KADAR ÇOK İŞ YÜKÜ OLACAĞINI GÖRELİM: ---
 * 
 * 2 araç'a ait özellikleri yazıp kullanmak istiyoruz:
 *   renk, yakıt, yolcusayısı, maxHız.
 */
		String ilkAracRenk = "sarı";
		String ilkAracYakit = "benzin";
		int ilkAracYolcuSayisi = 7;
		int ilkAracMaxHiz = 220;
		
		String ikinciAracRenk = "sarı";
		String ikinciAracYakit = "benzin";
		int ikinciAracYolcuSayisi = 7;
		int ikinciAracMaxHiz = 220;
		
		ekranaYaz(ikinciAracRenk, ikinciAracYakit, ikinciAracYolcuSayisi, ikinciAracMaxHiz);
		// ------
		
		Araba araba1 = new Araba();
		araba1.renk = "yeşil";
		araba1.maxHiz = 55;
		araba1.yakit = "dizel";
		araba1.yolcuSayisi = 45;
		Araba araba2 = new Araba();
		araba2.renk = "kırmızı";
		araba2.maxHiz = 75;
		araba2.yakit = "benzin";
		araba2.yolcuSayisi = 30;
		
		ekranaYaz(araba1);

	}//main ends here
	
	public static void ekranaYaz(String renk, String yakit, int yolcuSayisi, int maxHiz) {
		System.out.println("Renk..........: " + renk);
		System.out.println("Yakıt.........: " + yakit);
		System.out.println("Yolcu Sayısı..: " + yolcuSayisi);
		System.out.println("Maximum Hız...: " + maxHiz);
	}
	
	public static void ekranaYaz(Araba araba) {
		System.out.println("Renk..........: " + araba.renk);
		System.out.println("Yakıt.........: " + araba.yakit);
		System.out.println("Yolcu Sayısı..: " + araba.yolcuSayisi);
		System.out.println("Maximum Hız...: " + araba.maxHiz);
	}

}//class ends here
