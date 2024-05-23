package com.ahmet.controller;

import java.util.Scanner;

import com.ahmet.repository.entity.Musteri;
import com.ahmet.service.MusteriService;

public class MusteriController {
	
	/* NOT: Bir sınıf içinde kullanacağınız varlıklar, değişkenler
	 * var ise bunları sınıf skop'unda tanımlamak daha doğru olacaktır.
	 * Her yeni değer için bir referans objesi yaratmanın anlamı yoktur.
	 */
	Scanner sc;
	Musteri musteri;
	MusteriService service = new MusteriService();
	
	public void MusteriKaydet() {
		System.out.println("*******************************");
		System.out.println("******** MÜŞTERİ EKLEME *******");
		System.out.println("*******************************");
		System.out.println();
		sc = new Scanner(System.in);
		musteri = new Musteri();
		System.out.print("Ad giriniz...........: ");
		musteri.setAd(sc.nextLine());
		System.out.print("Soyad giriniz........: ");
		musteri.setSoyad(sc.nextLine());
		System.out.print("Telefon giriniz....: ");
		musteri.setTelefon(sc.nextLine());
		service.save(musteri);		
	}
	
	public void MusteriListesiGöster() {
		System.out.println("********************************");
		System.out.println("******** MÜŞTERİ LİSTESİ *******");
		System.out.println("********************************");
		System.out.println();
		for(int i=0; i<service.findAll().size(); i++) {
			musteri = service.findAll().get(i); // index'i verilen müşteriyi alıp atıyoruz.
			System.out.println("Müşteri Id.............: " + musteri.getId());
			System.out.println("Müşteri Adı............: " + musteri.getAd());
			System.out.println("Müşteri Soyadı.........: " + musteri.getSoyad());
			System.out.println("Müşteri Telefon........: " + musteri.getTelefon());
			System.out.println("Müşteri Ekleme Tarihi..: " + musteri.getCreateDate());
			System.out.println("------------------------------------");
		}
	}

	
}

