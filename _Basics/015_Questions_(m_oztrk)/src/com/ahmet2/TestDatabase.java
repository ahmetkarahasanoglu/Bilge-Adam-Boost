package com.ahmet2;

public class TestDatabase {

	public static void main(String[] args) {
		
		Database.veriTabaniBaslangicDegerleri();
		Kullanici[] kullaniciListesi = Database.kullaniciListesi;		
		for (int i = 0; i < kullaniciListesi.length; i++) {
			if (kullaniciListesi[i] != null) {
				System.out.println(kullaniciListesi[i].isim + "-" + kullaniciListesi[i].id);
			}
		}

	}//main ends here

}//class ends here
