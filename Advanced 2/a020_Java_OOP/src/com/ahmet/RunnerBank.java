package com.ahmet;

import com.ahmet.entity.BankaHesap;
import com.ahmet.entity.Musteri;

public class RunnerBank {

	public static void main(String[] args) {
		
		Musteri musteri = new Musteri();
		musteri.ad = "Muhammet";
		musteri.adres = "Ankara";
		musteri.annekizliksoyadi = "aabbcc";
		musteri.id = 1; // ID 
		musteri.soyad = "HOCA";
		musteri.telefon = "0 555 999 87 77";
		
		BankaHesap hesap = new BankaHesap();
		hesap.hesapno = "534535636252";
		hesap.iban = "TR98 4674 4634 3563 2345 34";
		hesap.miktar = 150_000;
		hesap.musteri_id = 1; // bu ID'yi müşteriler arasında (musteri.id) aratıp bulmamız gerekir.
		
/*
 * 1- [yukardaki yöntem] Birbiri ile ilişkilii dataları, sınıfları İlişkilendirmek
 * için genellikle çoklu tarafta tekil tarafa ait bir id ile
 * atama yapılır . En çok uygulanan yöntemdir.
 * NOT: Bu yöntem ile ilişkiler arasında bilgi aramak için enaz 2
 * işlem yapılır; işlem adımları uzun olduğu için iyi kurgulanması
 * gerekir.
 * 
 * 2- [aşağıdaki yöntem] Çoklu tarafta tekli olan datanın tüm bilgileri tutularak
 * yapılır. Bu yöntem çok fazla datanın olmadığı ve yeterli 
 * sistem gücünün olduğu ortamlarda tercih edilir, kodlamada
 * ve kullanımda kolaylık sağlar.
 */
		BankaHesap hesap2; 
		hesap2 = new BankaHesap();
		hesap2.hesapno = "534535636252";
		hesap2.iban = "TR98 4674 4634 3563 2345 34";
		hesap2.miktar = 150_000;
		hesap2.musteri_id = 1;
		hesap2.musteri = musteri;
		// "Bu hesap kimin?" sorusunun cevabını bulmak için:
		System.out.println("Hesap sahibi: " + hesap2.musteri.ad);

	}//main ends here

}//class ends here
