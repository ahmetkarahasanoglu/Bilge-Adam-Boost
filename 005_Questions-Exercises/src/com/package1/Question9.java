package com.package1;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		
		// Kullanıcıdan alınan bir sayının çarpım tablosunu yazdıralım
		// 10'a kadar yazdıralım
		// 1x1=1
		// 1x2=2
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bir sayı giriniz (çarpım tablosu oluşturulacak): ");
		int usersNum = scanner.nextInt();
		for(int i=1; i<=10; i++) {
			System.out.println(usersNum + "x" + i + "=" + usersNum*i);			
		}
		
		
		

		
		scanner.close();
	}

}
