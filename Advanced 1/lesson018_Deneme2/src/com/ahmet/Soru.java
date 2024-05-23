package com.ahmet;

import java.util.Scanner;

public class Soru {
	int puan;
	static int siraNo;
	String icerik;
	String dogruCevap;
	String[] cevapIcerikleri;
	
	public void soruOlustur(String[] cevapSecenekleri) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("---Yeni Soru Oluşturma---");
		System.out.println("Soru içeriğini giriniz: ");
		icerik = scanner.nextLine();
		cevapIcerikleri = new String[cevapSecenekleri.length];
		for(int i=0; i<cevapSecenekleri.length; i++) {
			System.out.println(cevapSecenekleri[i] + " şıkkının içeriğini giriniz: ");
			cevapIcerikleri[i] = scanner.nextLine();
		}
		System.out.println("Doğru cevabı giriniz: ");
		dogruCevap = scanner.nextLine();
		System.out.println("Puanı giriniz: ");
		puan = Integer.parseInt(scanner.nextLine());
	}
}
