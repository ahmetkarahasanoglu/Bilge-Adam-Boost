package com.okulyonetimsistemi;

public class Test {

	public static void main(String[] args) {
		
		Manager manager = new Manager();
		
//		Memur memur = new Memur(null, null);
//		Ogrenci ogrenci = new Ogrenci(null, null);
//		Ogretmen ogretmen = new Ogretmen(null, null);
		
		
		Kisi kisi = new Kisi();
		
		Kisi memur = new Memur("Mahmut", null);
//		Kisi ogrenci = new Ogrenci("Onur", null);
		Kisi ogretmen = new Ogretmen("Ömer", null);
				
		manager.menu(memur);
//		manager.menu(ogrenci);
//		manager.menu(ogretmen);
		
		System.out.println(OysUtility.stringDegerAlma("Lütfen değer giriniz: "));

	}

}
