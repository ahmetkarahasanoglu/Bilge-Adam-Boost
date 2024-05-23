package com.ahmet;

import java.util.Scanner;

import com.ahmet.controller.UrunController;

public class Runner {
	
	private static UrunController controller = new UrunController();
	// IN THIS PAGE, WE WILL COMMUNICATE WITH CONTROLLER FILE.
	public static void main(String[] args) {
		
		/*
		 * Katmanlı yapıya uygun
		 * Ürün Takip Sistemi için
		 * Urun, UrunRepository, UrunService, UrunController
		 * sınıflarını kodlayınız. İçinde: save, update, delete,
		 * findAll olsun.
		 */
		
		
 
		int secim = 0;
		do {
			secim = girisEkrani();
			switch(secim) {
				case 1: urunEkle(); break;
				case 2: urunListele(); break;
				case 3: urunBul(); break;
				case 4: urunYenile(); break;
				case 5: urunSil(); break;
				case 0: System.out.println("Çıkış yapılıyor."); break;
				default: System.out.println("Geçersiz seçim! Lütfen geçerli bir seçim yapınız.");
			}
		}while(secim!=0);
		

	}//main ends here
	
	private static int girisEkrani() {
		System.out.println("**************************");
		System.out.println("******* STOK TAKİP *******");
		System.out.println("**************************");
		System.out.println();
		System.out.println("1- Ürün Ekle");
		System.out.println("2- Ürün Listesi");
		System.out.println("3- Ürün Bul");
		System.out.println("4- Ürün Yenile");
		System.out.println("5- Ürün Sil");
		System.out.println("0- ÇIKIŞ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Seçim yapınız....: ");
		int secim = sc.nextInt();
		return secim;
	}
	
	private static void urunEkle() {
		System.out.println("****** ÜRÜN EKLEME *******");
		Scanner sc = new Scanner(System.in);
		System.out.print("Ürün adı......: ");
		String ad = sc.nextLine();
		System.out.print("Ürün markası......: ");
		String marka = sc.nextLine();
		System.out.print("Ürün modeli......: ");
		String model = sc.nextLine();
		System.out.print("Ürün fiyatı......: ");
		double fiyat = sc.nextDouble();
		System.out.print("Ürün maliyeti......: ");
		double maliyet = sc.nextDouble();
		System.out.print("Ürün adedi......: ");
		int adet = sc.nextInt();
		controller.save(ad, fiyat, maliyet, marka, model, adet);
		System.out.println();
		
	}
	private static void urunListele() {
		System.out.println("****** ÜRÜN LİSTESİ *******");
		System.out.format("%32s \n", "      Ad     |      Fiyat     ");
		for(int i=0; i<controller.size(); i++) {
			int size = (16 - controller.findAll()[i].ad.length())/2;
			System.out.format("%"+size+"s", controller.findAll()[i].ad);
			System.out.format("%"+size+"s","");
			System.out.format("%"+size+"s", controller.findAll()[i].fiyat);
			System.out.format("%"+size+"s","");
		}
		
	}
	
	private static void urunBul() {}
	private static void urunYenile() {}
	private static void urunSil() {}

}//class ends here
