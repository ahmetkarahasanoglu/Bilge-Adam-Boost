package com.ahmet;

public class Test {

	public static void main(String[] args) {
//		Soru soru = new Soru();
//		String[] cevapSecenekleri = { "A", "B", "C", "D" };
//		soru.soruOlustur(cevapSecenekleri);		
//		for(int i=0; i<soru.cevapIcerikleri.length; i++) {
//			System.out.println(soru.cevapIcerikleri[i]);
//		}
		
		Sinav sinav = new Sinav();
		sinav.sinavOlustur();

		sinav.cevaplariGir();
		sinav.cevaplariKontrolEt();
		

	}//main ends here

}//class ends here
