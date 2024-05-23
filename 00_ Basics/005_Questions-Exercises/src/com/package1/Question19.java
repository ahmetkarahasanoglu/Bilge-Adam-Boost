package com.package1;

import java.util.Scanner;

public class Question19 {

	public static void main(String[] args) {
	
		/* Question: Write the code that checks if the entered number is
		 * prime number or not. (prime number: asay sayı)
		 * */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = scanner.nextInt();
		boolean isPrimeNumber = true;
		
		if(input < 2) { // 1, 0 and negative numbers are not prime numbers.
			System.out.println("It's not a prime number");
		}else {
			for(int i=2; i<=input-1; i++) {
				if (input % i == 0) {
					isPrimeNumber = false;
					break;
				}			
			}		
			
			if(isPrimeNumber == false) {
				System.out.println("It's not a prime number.");
			} else {			
				System.out.println("It's a prime number.");
			}
		}
		
		
		

		
		scanner.close();
	}
}
