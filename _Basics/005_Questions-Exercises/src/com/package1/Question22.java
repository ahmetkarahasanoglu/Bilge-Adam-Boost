package com.package1;

import java.util.Scanner;

public class Question22 {

	public static void main(String[] args) {
		
	/* Soru: Dışarıdan ay ve gün değerini ayrı ayrı alacaksınız. Buna 
	 * göre burç hesabı yapacaksınız.
	 * 
	 * Kova Burcu	: 22 Ocak  - 19 Şubat
	 * Balık Burcu	: 20 Şubat - 20 Mart
	 * Koç Burcu	: 21 Mart  - 20 Nisan
	 * Boğa Burcu	: 21 Nisan - 21 Mayıs
	 * İkizler Burcu: 22 Mayıs - 22 Haziran
	 * Yengeç Burcu : 23 Haziran - 22 Temmuz	 * 
	 * AslanBurcu	: 23 TEmmuz - 22 Ağustos
	 * Başak Burcu	: 23 Ağustos - 22 Eylül
	 * Terazi Burcu	: 23 Eylül - 22 Ekim
	 * Akrep Burcu	: 23 Ekim - 21 Kasım
	 * Yay Burcu	: 22 Kasım - 21 Aralık
	 * Oğlak Burcu	: 22 Aralık - 21 Ocak 
	 */
		Scanner scanner = new Scanner(System.in);
		boolean willLoopRunAgain = false;
		
		do {
			willLoopRunAgain = false;
			System.out.print("Hangi ayda doğduğunuzu sayı olarak giriniz: ");
			int month = scanner.nextInt();
			System.out.print("Ayın kaçıncı günü doğduğunuzu giriniz: ");
			int day = scanner.nextInt();
			
			switch(month) { // only first 3 months have been coded in this block.
				case 1:
					if (day>=22 && day<=31) {
						System.out.println("Burcunuz: " + "Kova");
					}else if(day>=1 && day<=21) {
						System.out.println("Burcunuz: " + "Oğlak");
					}else {
						System.out.println("Girdiğiniz gün geçersizdir. Lütfen geçerli bir gün giriniz.");
						willLoopRunAgain = true;
					}
					break;
				case 2:
					if (day>=1 && day<=19) {
						System.out.println("Burcunuz: " + "Kova");
					}else if(day>=20 && day<=29) {
						System.out.println("Burcunuz: " + "Balık");
					}else {
						System.out.println("Girdiğiniz gün geçersizdir. Lütfen geçerli bir gün giriniz.");
						willLoopRunAgain = true;
					}
					break;
				case 3:
					if (day>=1 && day<=20) {
						System.out.println("Burcunuz: " + "Balık");
					}else if(day>=21 && day<=31) {
						System.out.println("Burcunuz: " + "Koç");
					}else {
						System.out.println("Girdiğiniz gün geçersizdir. Lütfen geçerli bir gün giriniz.");
						willLoopRunAgain = true;
					}
					break;
				default:
					System.out.println("Girdiğiniz ay geçersizdir. Lütfen geçerli bir ay giriniz (1-12)");
					willLoopRunAgain = true;
			}
		}while(willLoopRunAgain);
		

		
		
		scanner.close();
	}	
}
