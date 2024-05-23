package com.ahmet.entity;

import java.util.Scanner;

public class Hayvan {
	// PROPERTIES
	public String tur; // örneğin: kangal kopegi
	public String ad;
	public int yasamsuresi; //the elapsed time as "days" in the lifetime
	public int yas;
	public long saat;
	public boolean aclikdurumu;
	public boolean asilimi;
	public int boy;
	public int agirlik;
	
	public String beslenmesekli; // etobur, otobur.
	/*
	 * Hareket Durumu:
	 * 1-> uyuyor
	 * 2-> uyanık ama yatıyor
	 * 3-> yürüyor
	 * 4-> ayakta duruyor
	 * 5-> koşuyor
	 * 6-> yüzüyor
	 * 7-> uçuyor
	 */
	public int hareketdurumu;
	
	// AKSİYONLAR -> METOT
	public void uyut() {
		hareketdurumu = 1;
	}
	public void uyandir() {
		hareketdurumu = 2;
	}
	public void yemekYe() {
		System.out.println("Hayvana yemek yedirildi.");
		aclikdurumu = false;
	}
	public boolean yemekYe(String yemekturu) {
		if(beslenmesekli.equals("Etobur")) {
			if(yemekturu.contains("et")) {
				System.out.println("Hayvan beslendi.");
				return true;
			}else {
				return false;
			}
		}else { // beslenme şekli "otobur" ise
			if(yemekturu.contains("ot")) {
				System.out.println("Hayvan beslendi.");
				return true;				
			}else {
				return false;
			}
		}
	}
	
	public void yaslandir() { // 1 gün yaşlandırır
		yasamsuresi++; // gün
		if(yasamsuresi%365==0) {
			yas++;
			System.out.println("Mutlu yıllar, doğum günü kutlu olsun.");
		}
	}
	
	public void birSaat() throws InterruptedException {
		saat++;
		if(saat%24==0) {
			yaslandir();			
		}
		acikmisMi();
		Thread.sleep(1000); // Kodun işleyişini 1 saniye kadar bekletir.
	}
	
	public void acikmisMi() {
		if(saat%4 == 0) {
			aclikdurumu = true;
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Acıktım, yemek ver[E/H]...");
			if(sc.nextLine().equals("E")) {
				yemekYe();
			}
		}else {
			aclikdurumu = false;
		}
	}
}
