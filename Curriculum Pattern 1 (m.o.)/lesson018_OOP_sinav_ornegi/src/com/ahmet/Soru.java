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
		System.out.println("Lütfen sorunun içeriğini giriniz: ");
		icerik = scanner.nextLine();
		cevapIcerikleri = new String[cevapSecenekleri.length];
		for(int i=0; i<cevapSecenekleri.length; i++) {
			System.out.println("Lütfen " + cevapSecenekleri[i] + " şıkkının içeriğini giriniz: ");
			cevapIcerikleri[i] = scanner.nextLine();
		}
		System.out.print("Sorunun doğru cevabını belirtin: ");
		dogruCevap = scanner.nextLine().toUpperCase();
		System.out.print("Sorunun puanını belirtiniz: ");
		puan = Integer.parseInt(scanner.nextLine()); // (scanner.nextInt kullanmamak için böyle yaptık. [dummy nextLine yazmayalım dedik] - böyle bir kullanım yöntemi de mevcut. 
	}
	

}
