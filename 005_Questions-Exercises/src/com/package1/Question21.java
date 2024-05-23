package com.package1;

import java.util.Scanner;

public class Question21 {

	public static void main(String[] args) {
		
		/* Take a number as input between 1 and 7. Print the corresponding
		 * day of the number.
		 * */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number between 1 and 7: ");
		int number = scanner.nextInt();
		
		switch(number) {
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); break;
		case 7: System.out.println("Sunday"); break;
		default: System.out.println("Invalid number! The number you entered must be between 1-7 (inclusive)");
		}
		
		System.out.println("-----------------------------------");		
		
		System.out.print("Enter number between 1 and 7: ");
		int number2 = scanner.nextInt();
		
		switch(number2) {
		case 1,2,3,4,5: 
			System.out.println("It's a weekday.");
			break;
		case 6,7:
			System.out.println("It's weekend.");
			break;
			default: System.out.println("Invalid number! The number you entered must be between 1-7 (inclusive)");
		}
		
		scanner.close();
	}
}
