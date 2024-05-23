package com.package1;

import java.util.Scanner;

public class Question13 {

	public static void main(String[] args) {
		
		// Soru: Dışarıdan taban değeri ve üs değeri alallım (2 üzeri 5 gibi)
		// Bu işlemin sonucunu bulalım.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter number: ");
		int base = scanner.nextInt();
		System.out.print("Please enter the power: ");
		int power = scanner.nextInt();
		int result = 1;
		for(int i=1; i<=power; i++) {
			result = result * base;
		}
		System.out.println(base + "^" + power + "=" + result);
		
		
	scanner.close();
	}
}
