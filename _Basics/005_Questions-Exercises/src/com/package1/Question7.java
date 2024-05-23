package com.package1;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		
		// Soru: Kullanıcıdan 2 tane sayısal değer alalım. İki sayının 
		// toplamı çift ise true, tek ise false yazdıralım. En sonunda da
		// toplamın yarısını ekrana yazdıralım.
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("İlk sayısal değeri giriniz: ");
		int num1 = scanner.nextInt();
		System.out.print("İkinci sayısal değeri giriniz: ");
		int num2 = scanner.nextInt();
		int sum = num1 + num2;
		boolean isEvenNumber = (num1 + num2) % 2 == 0;
		System.out.println("Toplam değer çift sayı mı?: " + isEvenNumber);
		System.out.println("Toplam değer: " + sum);
		System.out.println("Toplamın yarısı: " + sum/2f);
		
		scanner.close();
	}

}
