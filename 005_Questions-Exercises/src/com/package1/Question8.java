package com.package1;

import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {		
		
		// Soru: Kullanıcıdan alınan bir sayının faktöriyelini hesaplayalım.
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scanner.nextInt();
		
		int factorial = 1;
		for(int i=num; i>0; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial is: " + factorial);
		
		scanner.close();
	}

}
