package com.ahmet.satis;
import com.ahmet.satis.entity.Satis;
import com.ahmet.satis.entity.Urun;
import java.util.Scanner;

public class Runner {
	
	static Urun[] urunList = new Urun[2];
	static int indexUrun = 0;
	
	
	public static void main(String[] args) {
		Satis[] satislar = new Satis[4]; // Bugün 4 satış yaptık diyelim. (4 kez kasadan ürünler geçti; 4 satış oldu)
		int secim;
		do{
			secim = secimYap();
			switch(secim) {
				case 1: urunEkle(); break;
				case 2: urunListesi(); break;
				case 3: satisYap(); break;
				case 4: satisListesi(); break;
				case 5: enCokSatilanUrun(); break;
				case 6: enBuyukSatis(); break;
				case 0: System.out.println("Çıkış yapılıyor..."); break;
				default: System.out.println("Geçersiz seçim! Lütfen menü başlıklarından seçim yapınız.");
			}
			
		}while(secim!=0);

	}//main ends here
	
	public static void urunEkle() {		
		baslikYazdir("Ürün Ekle");
		if(indexUrun==urunList.length) {
			System.out.println("-Ürün listesi dolmuştur.-");
		}else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Ürün adı.......: ");
			String ad = sc.nextLine();
			System.out.print("Ürün fiyatı....: ");
			double fiyat = sc.nextDouble();
			System.out.print("Ürün maliyeti..: ");
			double maliyet = sc.nextDouble();
			sc.nextLine(); // dummy
			System.out.print("Ürün markası...: ");
			String marka = sc.nextLine();
			System.out.print("Ürün modeli....: ");
			String model = sc.nextLine();
			System.out.print("Kdv oranı......: ");
			int kdv = sc.nextInt();
			System.out.print("Ürün adedi.....: ");
			int adet = sc.nextInt();
			sc.nextLine(); // dummy
			
			Urun urun = new Urun();
			urun.ad = ad;
			urun.fiyat = fiyat;
			urun.maliyet = maliyet;
			urun.marka = marka;
			urun.model = model;
			urun.kdv = kdv;
			urun.adet = adet;		
			
			urunList[indexUrun] = urun;
			indexUrun++;
		}
	}

	public static void urunListesi() {		
		baslikYazdir("Ürün Listesi");		
		for(int i=0; i<urunList.length; i++) {
			if(urunList[i] != null) {
				System.out.println("--------------------------------");
				System.out.println("Ürün adı.......: " + urunList[i].ad);
				System.out.println("Ürün fiyatı....: " + urunList[i].fiyat);
				System.out.println("Ürün maliyeti..: " + urunList[i].maliyet);
				System.out.println("Ürün markası...: " + urunList[i].marka);
				System.out.println("Ürün modeli....: " + urunList[i].model);
				System.out.println("Kdv oranı......: " + urunList[i].kdv);
				System.out.println("Ürün adedi.....: " + urunList[i].adet);
			}else {
				System.out.println("-Ürün bulunamadı.-");
			}
			
		}
	}

	public static void satisYap() {
		baslikYazdir("Satış Yap");
		
	}
	
	public static void satisListesi() {
		baslikYazdir("Satış Listesi");
		
	}
	
	public static void enCokSatilanUrun() {
		baslikYazdir("En Çok Satılan Ürün");
		
	}
	
	public static void enBuyukSatis() {
		baslikYazdir("En Büyük Satış");
		
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
	
	public static void baslikYazdir(String baslik) {
		System.out.println("*****************************");
		System.out.println("****** " + baslik + " *******");
		System.out.println("*****************************");
	}

}//class ends here
