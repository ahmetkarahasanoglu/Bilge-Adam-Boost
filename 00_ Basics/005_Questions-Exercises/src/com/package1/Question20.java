package com.package1;

import java.util.Scanner;

public class Question20 {

	public static void main(String[] args) {
		
		/* Question: Find out if the entered number is a power of 5.
		 * */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = scanner.nextInt();
		boolean control = true;
		if(number == 1) { // 5^0 = 1 --> 1 is a power of 5.
			System.out.println("It's a power of 5.");
			control=false;
		}else if(number <= 0) {
			System.out.println("It's NOT a power of 5.");
			control = false;
		}
		
		while(control) {
			if(number % 5 == 0) {
				number = number / 5;
				if(number == 1) {
					System.out.println("It's a power of 5.");
					control = false;
				}
			}else {
				System.out.println("It's NOT a power of 5.");
				control = false;
			}
			
		}
		

		
		
		scanner.close();
	}
}
