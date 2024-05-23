package com.package2;

import java.util.Scanner;

public class Question30 {

	public static void main(String[] args) {
		/*
		 * Dışarıdan bir IBAN değeri girelim; TR 1001005001, TR 1001005002 
		 * veya OTH 2002002000 gibi. Sonra bu değerleri kontrol edelim. 
		 * Eğer TR ile başlıyorsa yurt içi işlemler yazsın ve eğer 5001 
		 * ile bitiyorsa Ziraat, 5002 ile bitiyorsa Garanti, 5003 ile 
		 * bitiyorsa İş bankası yazdırsın. Eğer OTH ise Yurt dışı 
		 * işlemler yazdıralım, 2000 ile bitiyorsa kıta içi işlemler 
		 * ve OTH yerine Ki 200200..., değilse kıta dışı işlemler yazsın 
		 * ve OTH yerine Kd 200200...
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("IBAN giriniz: ");
		String iban = sc.nextLine();
		iban = iban.trim();
		if(iban.startsWith("TR")) {
			System.out.println("Yurtiçi işlemler");
			if(iban.endsWith("5001")) {
				System.out.println("Ziraat Bankası");
			}else if(iban.endsWith("5002")) {
				System.out.println("Garanti Bankası");
			}else if(iban.endsWith("5003")) {
				System.out.println("İş Bankası");
			}
		}else if(iban.startsWith("OTH")) {
			System.out.println("Yurt dışı işlemler");
			if(iban.endsWith("2000")) {
				System.out.println("Kıta içi işlemler. " + iban.replace("OTH", "Kİ"));
			}else {
				System.out.println("Kıta dışı işlemler. " + iban.replace("OTH", "KD"));
			}
		}		
		
		

		sc.close();
	}
}
