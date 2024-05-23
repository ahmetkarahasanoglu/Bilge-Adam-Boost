package com.ahmet.satis;

import java.util.Date;
import java.util.Scanner;
import com.ahmet.satis.entity.Satis;
import com.ahmet.satis.entity.SatisDetay;
import com.ahmet.satis.entity.Urun;

public class Runner {
	static Urun[] urunList = new Urun[2]; // Her metot'tan erişilebilmesi için Class'ın içinde yazdık.
	static Satis[] satislar = new Satis[4]; // Bugün 4 satış yaptık diyelim. (4 kez kasadan ürünler geçti; 4 satış oldu)
	static int indexSatis = 0;
	static int indexUrun = 0;
	
	
	public static void main(String[] args) {
		/*
		 * SATIŞ OTOMASYON SİSTEMİ
		 * 1- Ürün Tanımlama
		 * 2- Satış
		 * 3- Rapor
		 */
		
		int secim;
		do {
			secim = secimYap();
			switch(secim) {
				case 1: urunEkleme(); break;
				case 2: urunListesi(); break;
				case 3: satisYap(); break;
				case 4: satisListesi(); break;
				case 5: enCokSatanUrun(); break;
				case 6: enBuyukSatis(); break;
				case 0: System.out.println("Exiting..."); break;
				default: System.out.println("Invalid selection! Please choose one of the titles in the menu."); break;			
			}
		}while(secim!=0);
		
		
		
		

	}//main ends here
	
	public static void urunEkleme() {		
		baslikYazdir("Ürün Ekleme");
		if(indexUrun==urunList.length) {
			System.out.println("-Ürün listesi dolmuştur.-");
		}else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Ürün adı: ");
			String ad = sc.nextLine();
			System.out.print("Ürün marka: ");
			String marka = sc.nextLine();
			System.out.print("Ürün model: ");
			String model = sc.nextLine();
			System.out.print("Ürün fiyat: ");
			double fiyat = sc.nextDouble();
			System.out.print("Ürün maliyet: ");
			double maliyet = sc.nextDouble();
			System.out.print("Ürün KDV oranı: ");
			int kdv = sc.nextInt();
			System.out.print("Ürün adet: ");
			int adet = sc.nextInt();
			
			Urun urun = new Urun();		
			urun.ad = ad;
			urun.marka = marka;
			urun.model = model;
			urun.fiyat = fiyat;
			urun.maliyet = maliyet;
			urun.kdv = kdv;
			urun.adet = adet;
			urunList[indexUrun] = urun;
			indexUrun++;
		}		
		
	}
	public static void urunListesi() {
		baslikYazdir("Ürün Listesi");
		for(int i=0; i<urunList.length; i++) {
			System.out.println("--------------------------------");
			System.out.println("Ürün adı......: " + urunList[i].ad);
			System.out.println("Ürün fiyatı...: " + urunList[i].fiyat);
			System.out.println();
			
		}
	}
	public static void satisYap() {
		baslikYazdir("Satış Yap");
		System.out.print("Kasiyer ismi giriniz...: ");
		Scanner sc = new Scanner(System.in);
		String kasiyer = sc.nextLine();		
		/* Diziler sınırlı genişlikle tanımlanır.Fakat
		 * uygulamaların doğası esnek olmaktır. Burada bir sorun
		 * karşımıza çıkıyor: genişeleyebilir dizilerin olmaması.*/
		
		Satis satis = new Satis();
		satis.kasiyer = kasiyer;
		System.out.print("Ödeme yöntemi giriniz...: ");
		String odemeyontemi = sc.nextLine();
		satis.odemeYontemi = odemeyontemi;		
		satis.tarih = new Date(); // şu anki tarih.
		satis.satisNo = indexSatis;		
		SatisDetay[] detay = new SatisDetay[2]; // (this is an array). Her satışta 2 ürün satalım dedik (2 ürün kasadan geçsin sadece).
		double genelToplam = 0;
		for(int i=0; i<2; i++) {
			Scanner scDetay = new Scanner(System.in);
			SatisDetay urun = new SatisDetay();	 // (this is an object).	
			System.out.print("Ürün adı......: ");
			urun.urunAdi = scDetay.nextLine();
			System.out.print("Ürün fiyatı.: ");
			urun.fiyat = scDetay.nextDouble();
			System.out.print("Ürün adedi..: ");
			urun.adet = scDetay.nextInt();
			urun.toplamFiyat = urun.fiyat * urun.adet;
			genelToplam += urun.toplamFiyat;
			detay[i] = urun;
		}
		satis.satisDetay = detay;
		satis.toplamFiyat = genelToplam;
		satislar[indexSatis] = satis;
		indexSatis++;
		
	}
	public static void satisListesi() {
		baslikYazdir("Satış Listesi");
		
	}
	public static void enCokSatanUrun() {
		baslikYazdir("En Çok Satan Ürün");
		
	}
	public static void enBuyukSatis() {
		baslikYazdir("En Büyük Satış");
		
	}
	public static void baslikYazdir(String baslik) {
		System.out.println("************************************");
		System.out.println("******** " + baslik + " *********");
		System.out.println("************************************");
	}

	public static int secimYap() {
		baslikYazdir("SATIŞ OTOMASYONU");
		System.out.println();
		System.out.println("1- Ürün Ekleme");
		System.out.println("2- Ürün Listesi");
		System.out.println("3- Satış Yap");
		System.out.println("4- Satış Listesi");
		System.out.println("5- En Çok Satılan Ürün");
		System.out.println("6- En Büyük Satış (Fiyat Olarak)");
		System.out.println("0- ÇIKIŞ");
		Scanner sc = new Scanner(System.in);
		System.out.print("Lütfen seçim yapınız...: ");
		int secim = sc.nextInt();		
		return secim;
	}

}//class ends here
