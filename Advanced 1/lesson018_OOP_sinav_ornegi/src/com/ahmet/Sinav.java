package com.ahmet;

import java.util.Scanner;

public class Sinav {
	String ders;
	String konu;
	int sinavNo;
	int soruSayisi;
	long sure;
	String tarih;
	Soru[] sorular;
	String[] cevaplar;
	String[] cevapSecenekleri = { "A", "B", "C", "D" };
	
	
	public void sinavOlustur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen sınav konusunu giriniz: ");
		konu = scanner.nextLine();
		System.out.println("Lütfen soru sayısını giriniz: ");
		soruSayisi = Integer.parseInt(scanner.nextLine());
		System.out.println("Lütfen sınav süresini giriniz: ");
		sure = Long.parseLong(scanner.nextLine());		
		sorular = new Soru[soruSayisi];
		
		for(int i=0; i<sorular.length; i++) {
			Soru soru = new Soru();
			soru.soruOlustur(cevapSecenekleri);
			sorular[i] = soru;
		}
		
	}
	public void cevaplariGir() { // kullanıcının cevapları
		Scanner scanner = new Scanner(System.in);
		cevaplar = new String[sorular.length];		
		for(int i=0; i<sorular.length; i++) {
			System.out.println(sorular[i].icerik);
			for(int j=0; j<sorular[i].cevapIcerikleri.length; j++) {
				System.out.println(cevapSecenekleri[j] + "-)" + sorular[i].cevapIcerikleri[j]);
			}
			System.out.print("Cevabınızı giriniz: ");
			String cevap = scanner.nextLine().toUpperCase();			
			cevaplar[i] = cevap;
		}
	}
	
	public void cevaplariKontrolEt() {
		int dogruCevapSayisi = 0;
		int toplamPuan = 0;
		for(int i=0; i<sorular.length; i++) {
			if(sorular[i].dogruCevap.equalsIgnoreCase(cevaplar[i])) {
				dogruCevapSayisi++;
				toplamPuan += sorular[i].puan;
			}
		}
		System.out.println("--- Sınav Sonucu ---");
		System.out.println("Puanınız.............: " + toplamPuan);
		System.out.println("Doğru cevap sayısı...: " + dogruCevapSayisi);
		System.out.println("Yanlış cevap sayısı..: " + (sorular.length - dogruCevapSayisi));
	}

	
	
}
