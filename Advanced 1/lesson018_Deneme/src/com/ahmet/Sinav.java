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
		System.out.println("Konuyu giriniz: ");
		konu = scanner.nextLine();
		System.out.println("Soru sayısını giriniz: ");
		soruSayisi = scanner.nextInt();
		scanner.nextLine(); // dummy
		sorular = new Soru[soruSayisi];
		for(int i=0; i<sorular.length; i++) {
			Soru soru = new Soru();
			soru.soruOlustur(cevapSecenekleri);
			sorular[i] = soru;
		}
	}
	
	public void cevaplariGir() {
		Scanner scanner = new Scanner(System.in);
		cevaplar = new String[sorular.length];
		for(int i=0; i<sorular.length; i++) {
			System.out.println(sorular[i].icerik);
			for(int j=0; j<sorular[i].cevapIcerikleri.length; j++) {
				System.out.println(cevapSecenekleri[j] + "-)" + sorular[i].cevapIcerikleri[j]);
			}
			System.out.println("Cevabınızı giriniz: ");
			cevaplar[i] = scanner.nextLine();
		}
		
	}
	
	public void cevaplariKontrolEt() {
		int toplamPuan = 0;
		int dogruSayisi = 0;
		for(int i=0; i<sorular.length; i++) {
			if(sorular[i].dogruCevap.equalsIgnoreCase(cevaplar[i])) {
				dogruSayisi++;
				toplamPuan += sorular[i].puan;
			}
		}
		System.out.println("--- Sınav Sonucu ---");
		System.out.println("Doğru sayısı: " + dogruSayisi);
		System.out.println("Yanlış sayısı: " + (sorular.length - dogruSayisi));
		System.out.println("Toplam puan: " + toplamPuan);
	}
}
