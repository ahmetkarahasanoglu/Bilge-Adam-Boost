package com.ahmet;

import com.ahmet.entity.BaglantiYonetimi;

public class Runner {

	public static void main(String[] args) {
		
		BaglantiYonetimi baglanti = new BaglantiYonetimi();
//		System.out.println("Bağlantı Adresi......: " + baglanti.baglanti_adresi);
//		baglanti.baglanti_adresi = "Ankara";
//		System.out.println("Bağlantı Adresi......: " + baglanti.baglanti_adresi);
//		baglanti.baglanti_adresi = "İstanbul";
//		System.out.println("Bağlantı Adresi......: " + baglanti.baglanti_adresi);
		
		baglanti.getBaglanti_adresi("Admin");
		
		baglanti.setBaglanti_adresi("124.33.21", "NotAdmin", "SuperUser");
		
	}//main ends here

}//class ends here
