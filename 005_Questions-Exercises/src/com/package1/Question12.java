package com.package1;

import java.util.Scanner;

public class Question12 {

	public static void main(String[] args) {
		
		// Soru: Girilen sayının basamakları toplamını ekranan yazdıralım.
		// (sayı değerlerinin toplamını)
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int num = scanner.nextInt();
		int originalNum = num; 
		int sum = 0;
		while(num != 0) {			
			int digit = num % 10;;
			sum = sum + digit;
			num = num / 10;			
		}
		System.out.println("The sum of each digit of the number: " + sum);
		
		

		scanner.close();
	}
}
