package com.ahmet.controller;

import java.util.Scanner;

import com.ahmet.repository.entity.Hasta;
import com.ahmet.service.HastaService;

public class HastaController {
	Scanner sc;
	Hasta hasta;
	HastaService service = new HastaService();


	public void HastaKaydet() {
		System.out.println("*******************************");
		System.out.println("********* HASTA EKLEME ********");
		System.out.println("*******************************");
		System.out.println();
		sc = new Scanner(System.in);
		hasta = new Hasta();
		System.out.print("Ad soyad giriniz...........: ");
		hasta.setAdiSoyadi(sc.nextLine());
		System.out.print("Hastalik giriniz........: ");
		hasta.setHastalik(sc.nextLine());		
		service.save(hasta);	
	}
	
	public void HastaListesiGöster() {
		System.out.println("********************************");
		System.out.println("********* HASTA LİSTESİ ********");
		System.out.println("********************************");
		System.out.println();
		for(int i=0; i<service.findAll().size(); i++) {
			hasta = service.findAll().get(i); // index'i verilen müşteriyi alıp atıyoruz.
			System.out.println("Hasta Id.............: " + hasta.getId());
			System.out.println("Hasta No ............: " + hasta.getHastaNo());
			System.out.println("Hasta Adı Soyadı.....: " + hasta.getAdiSoyadi());
			System.out.println("Hastalık.............: " + hasta.getHastalik());
			System.out.println("Müşteri Ekleme Tarihi..: " + hasta.getCreateDate());
			System.out.println("------------------------------------");
		}
	}

}