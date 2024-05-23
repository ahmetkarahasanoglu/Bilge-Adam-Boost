package com.package2;

public class Question36 {

	public static void main(String[] args) {
		
		/* Soru: Aşağıda verilen dizideki tüm sayıların toplamı ve 
		 * bu sayı çifttir, bu sayı tektir şeklinde çıktı alalım.
		 */
		int[] sayilar = { 0,120,5,85,-256, 16, 1258, 81,14 };
		int toplam = 0;		
		
		for (int i=0; i<sayilar.length; i++) {
			toplam += sayilar[i];
			if(sayilar[i] % 2 == 0) {
				System.out.println("index " + i + "'de bulunan " + sayilar[i] + " sayısı ÇİFTTİR.");
			}else if(sayilar[i] % 2 == 1) {
				System.out.println("index " + i + "'de bulunan " + sayilar[i] + " sayısı TEKTİR.");
			}		
			
			
		}
		System.out.println();
		System.out.println("Toplam: " + toplam);
		
		
		
	}
}
