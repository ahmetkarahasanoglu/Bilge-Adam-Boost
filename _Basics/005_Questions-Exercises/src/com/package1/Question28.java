package com.package1;

import java.util.Scanner;

public class Question28 {

	public static void main(String[] args) {
		
	/* Question: Take a string input from user, like:
	 *           Apple,Banana,Orange
	 * By using a for loop, and without using split method, print it
	 * like this:
	 * Apple
	 * Banana
	 * Orange
	 */
		// ******** Teacher's Code: **********
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter items; use comma for seperating items: ");
		String input = sc.nextLine();
		int index = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ',') {
				System.out.println(input.substring(index, i));
				index = i+1;
			}
		}
		System.out.println(input.substring(index));
		
		// ******** Teacher's Another Way: ************
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter items; use comma for seperating items: ");
//		String input = sc.nextLine();
//		for(int i=0; i<input.length(); i++) {
//			if(input.charAt(i) == ',') {
//				System.out.println();
//			} else {
//				System.out.print(input.charAt(i));
//			}
//		}
		
		// *********** 3rd Way: ***********
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter items; use comma for seperating items: ");
//		String input = sc.nextLine();
//		input = input.replace(",", "\n");
//		System.out.println(input);
		
		// ********** My Code (less useful) ********* 
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter items; use comma for seperating items: ");
//		String input = sc.nextLine();
//		for(int i=0; i>=0; i++) {
//			if(input.contains(",")) {
//				System.out.println( input.substring(0, input.indexOf(",")) );
//				input = input.substring(input.indexOf(",")+1);
//			}else {
//				System.out.println(input);
//				break;
//			}			
//		}
		
		
		
		sc.close();
	}
}
