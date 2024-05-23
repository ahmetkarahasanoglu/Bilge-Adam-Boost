package com.ahmet;

import java.util.Scanner;

/*
 * --- KİTAPLIK UYGULAMASI ---
 * 1) Kitaplarımızın isim, yazar, sayfa sayısı, isbn kodu özellikleri olsun.
 * 2) Yazarlarımızın ismi ve yaşı olsun.
 * 3) Kitaplık sınıfımızda boyut özelliği ve kitap listesi olsun.
 * 4) Uygulama sınıfımızda aşağıdaki metotlarımız olsun:
 * 	  1- Kitap ekle (yazar ismi ve kitap ismi kriterlerine dikkat edelim)
 * 	  2- Kitap sil
 *    3- İsme göre kitap bul
 *    4- Yazarın kitaplarını bul
 *    5- Kitapları listele
 *    6- Yazarları listele
 */
public class Uygulama {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		uygulamayiBaslat();
	}//main ends here
	
	public static void uygulamayiBaslat() {
		Kutuphane kutuphane = new Kutuphane(); // kitaplık nesnesi oluşturduk.
		kutuphane.boyut = 50;
		kutuphane.kitapListesi = new Kitap[kutuphane.boyut]; // 'kitapListesi' alanını 5 boyutunda "Kitap array'i" olarak belirledik.
		
		int secim;
		do {
			menu();			
			secim = secimYap();
			scanner.nextLine(); // dummy
			switch(secim) {
				case 1:
					kitapEkle(kutuphane);
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					kitaplariListele(kutuphane.kitapListesi);
					break;
				case 6:
					yazarlariListele(kutuphane.yazarListesi);
					break;
				case 0:
					System.out.println("Uygulamadan çıkılıyor...");
					break;
				default:
					System.out.println("Geçersiz seçim!");
			}
			
		}while(secim!=0);
	}
	
	public static void menu() {
		System.out.println("1-Kitap Ekle");
		System.out.println("2-Kitap Sil");
		System.out.println("3-Kitap İsmine Göre Ara");
		System.out.println("4-Yazar İsmine Göre Ara");
		System.out.println("5-Kitapları Listele");
		System.out.println("6-Yazarları Listele");
		System.out.println("0-Çıkış");
	}
	
	public static int secimYap() {
		System.out.print("Lütfen işlem seçiniz: ");		
		return scanner.nextInt();
	}
	
	public static void kitapEkle(Kutuphane kutuphane) {
		Kitap kitap = new Kitap();
		Yazar yazar = new Yazar();
		System.out.println("--- Kitap Ekleme ---");
		System.out.print("Kitap ismi giriniz: ");
		kitap.isim = scanner.nextLine();
		System.out.print("Kitap yazarının ismini giriniz: ");
		String yazarIsmi = scanner.nextLine();
		kitap.yazar = kutuphane.yazarKontrol(yazarIsmi); // We're passing yazarIsmi as parameter, and yazar object returns from the function.
		System.out.print("Sayfa sayısı giriniz: ");
		kitap.sayfaSayisi = scanner.nextInt();
		
		kutuphane.kitapListesi[Kutuphane.index] = kitap;
		Kutuphane.index++;
	}
	
	public static void kitaplariListele(Kitap[] kitapListesi) {
		for(int i=0; i<kitapListesi.length; i++) {
			if(kitapListesi[i] != null) {
				System.out.println((i+1) + " - " + kitapListesi[i].isim + "-" + kitapListesi[i].yazar.isim);
			}
			
		}
	}
	
	public static void yazarlariListele(Yazar[] yazarListesi) {
		for(int i=0; i<yazarListesi.length; i++) {
			if(yazarListesi[i] != null) {
				System.out.println((i+1) + " - " + yazarListesi[i].isim + ". Yazarın yaşı: " + yazarListesi[i].yas);
			}
		}
	}
	
	
	

}//class ends here
