package com.ahmet;

public class Test {

	public static void main(String[] args) {
		
//		Soru soru = new Soru();
//		String[] cevapSecenekleri = { "A", "B", "C", "D" };
//		soru.soruOlustur(cevapSecenekleri);
		
		Sinav sinav = new Sinav();
		sinav.sinavOlustur();
		sinav.cevaplariGir();
		sinav.cevaplariKontrolEt();

	}//main ends here

}//class ends here
