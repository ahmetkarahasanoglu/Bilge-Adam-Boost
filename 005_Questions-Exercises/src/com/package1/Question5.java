package com.package1;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		int sayi1 = scanner.nextInt();
//		double sayi2 = scanner.nextDouble();
//		String sayi3 = scanner.nextLine();

		System.out.print("Lütfen bir sayi giriniz: ");
		int sayi = scanner.nextInt();
		// Sayısal değer aldıktan sonra string bir değer alacaksak 
		// bir tane boş scan.nextLine() yazıyoruz. 
		scanner.nextLine();
		System.out.println("Sayi --> " + sayi);
		
		System.out.print("Lütfen bir string giriniz: ");
		String str = scanner.nextLine();
		System.out.println("String değer --> " + str);
		
		scanner.close();
	}

}
