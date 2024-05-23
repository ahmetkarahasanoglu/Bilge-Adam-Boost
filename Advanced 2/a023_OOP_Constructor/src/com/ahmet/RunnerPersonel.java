package com.ahmet;

import com.ahmet.entity.Personel;

public class RunnerPersonel {

	public static void main(String[] args) {
		Personel personel = new Personel("Ahmet", "İstanbul", "0 555 355 44 66", "15.05.2005");
		
		
		System.out.println("ad................: " + personel.ad);
		System.out.println("adres.............: " + personel.adres);
		System.out.println("telefon...........: " + personel.telefon);
		System.out.println("işe giriş tarihi..: " + personel.isegiristarihi);
		
	}
}
