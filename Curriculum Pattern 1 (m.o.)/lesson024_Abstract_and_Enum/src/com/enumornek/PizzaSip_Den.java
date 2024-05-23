package com.enumornek;

import database.Utility;

public class PizzaSip_Den {
	
	public static void main(String[] args) {
		
		PizzaSip_Den pizzaSip_Den = new PizzaSip_Den();
		pizzaSip_Den.menu();		
		
	}//MAIN ENDS HERE----------

	public void menu() {
		System.out.println("--- Pizza Sipariş Menüsü ---");
		Pizza pizza = pizzaSec();
		siparisHazirla(pizza);		
	}
	
	public Pizza pizzaSec() {
		ETur tur = turSec();
		EBoyut boyut = boyutSec();
		EHamurTipi hamurTipi = hamurTipiSec();
		
		Pizza pizza = new Pizza(tur, boyut, hamurTipi);
		return pizza;
	}
	
	public void siparisHazirla(Pizza pizza) {
		System.out.println("Pizzanız hazırlanıyor. Pizza detayları: ");
		System.out.println(pizza.toString());
	}
	
	public ETur turSec() {
		System.out.println("Pizza Türleri: ");
		for(ETur tur : ETur.values()) {
			System.out.println((tur.ordinal()+1) + "-" + tur);
		}
		int secim = Utility.intDegerAlma("Seçiniz: ");
		switch(secim) {
		case 1: 
			return ETur.TONBALIKLI;
		case 2: 
			return ETur.KARISIK;
		case 3: 
			return ETur.AKDENİZ;
		default:
			System.out.println("Geçersiz seçim!");	
			return null;
	}		
	}
	
	public EBoyut boyutSec() {
		System.out.println("Pizza boyutları: ");
		for(EBoyut boyut : EBoyut.values()) {
			System.out.println((boyut.ordinal()+1) + "-" + boyut);
		}
		int secim = Utility.intDegerAlma("Seçiniz: ");
		switch(secim) {
			case 1: 
				return EBoyut.BUYUK;
			case 2: 
				return EBoyut.ORTA;
			case 3: 
				return EBoyut.KUCUK;
			default:
				System.out.println("Geçersiz seçim!");	
				return null;
		}
	}
	
	public EHamurTipi hamurTipiSec() {
		System.out.println("Hamur tipleri: ");
		for(EHamurTipi hamurTipi : EHamurTipi.values()) {
			System.out.println((hamurTipi.ordinal()+1) + "-" + hamurTipi);
		}		
		int secim = Utility.intDegerAlma("Seçiniz: ");
		switch(secim) {
			case 1:
				return EHamurTipi.INCE;
			case 2:
				return EHamurTipi.NORMAL;
			case 3:
				return EHamurTipi.KALIN;
			default:
				System.out.println("Geçersiz seçim!");
				return null;
		}
	}
	
	
}//CLASS ENDS HERE----------
