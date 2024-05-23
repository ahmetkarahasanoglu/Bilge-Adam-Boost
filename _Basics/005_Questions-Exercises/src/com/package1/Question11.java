package com.package1;

public class Question11 {

	public static void main(String[] args) {
		
		// Soru: 1'den başlayarak sayıları toplayalım. Toplamımız 50'den
		// büyük olana kadar program çalışsın. Sonunda toplamı ve kaç
		// kere çalıştığını yazdıralım.		
		int i = 1;
		int total = 0;
		while(true) {
			total = total + i;			
			System.out.println("total: " + total + ". count: " + i);
			i++;
			if (total > 50) {
				break;
			}
		}
		System.out.println("TOTAL: " + total + ". COUNT: " + i);
		
		
		

	}

}
