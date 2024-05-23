package com.okulyonetimsistemi;

import java.util.Scanner;

/*
 * Memur için:
 * 1- öğrenci kaydı yap
 * 2- öğrenci kaydı sil
 * 3- bilgilendirme yap
 * 4- ders kaydı onayla
 * 5- Öğretmenler listesi
 * 6- Öğrenciler listesi
 * 
 * Öğrenci
 * 1- ders kaydı
 * 2- not ortalaması görüntüle
 * 3- aldığım derlseri listele
 * 
 * Öğretmen:
 * 1- girdiğim dersleri listele
 * 2- nöbetçilik durumu sorgula.
 */
public class Manager {
	
	Okul okul;
	
	public Manager() {
		
	}
	
	
	public void memurMenusu() {  // kullanmıycaz. Memur class'ında var aynısı, ordan kullancaz.
		System.out.println("*** Memur İşlemleri ***");
		System.out.println("1- Öğrenci kaydı yap");
		System.out.println("2- Öğrenci kaydı sil");
		System.out.println("3- Bilgilendirme yap");
		System.out.println("4- Ders kaydı onayla");
		System.out.println("5- Öğretmenler listesi");
		System.out.println("6- Öğrenciler listesi");
	}
	
	public void ogrenciMenusu() {  // kullanmıycaz. Ogrenci class'ında var aynısı, ordan kullancaz.
		System.out.println("*** Öğrenci İşlemleri ***");
		System.out.println("1- Ders kaydı");
		System.out.println("2- Not ortalaması görüntüle");
		System.out.println("3- Aldığım dersleri listele");
	}
	
	public void ogretmenMenusu() {  // kullanmıycaz. Ogretmen class'ında var aynısı, ordan kullancaz.
		System.out.println("*** Öğretmen İşlemleri ***");
		System.out.println("1- Girdiğim derleri listele");
		System.out.println("2- Nöbetçilik durumu sorgula");
	}
	
	
	public void menu(Kisi kisi) {   //  POLİMORFİZM
//		if(kisi instanceof Memur) {       // manuel 
//			memurMenusu();
//		}else if(kisi instanceof Ogrenci) {
//			ogrenciMenusu();
//		}else if(kisi instanceof Ogretmen) {
//			ogretmenMenusu();
//		}		
		kisi.menu();
	}
	
	
	
	
			



}//class ends here
