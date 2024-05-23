package com.package1;

import java.util.Scanner;

public class Question24minMax {

	public static void main(String[] args) {
		/* Find and print the max and min of the 5 numbers that are entered as input
		 * by the user. The numbers that the user enters can be between
		 * 0-100 (inclusive)
		 * */		
		Scanner scanner = new Scanner(System.in);
		System.out.println("You will enter 5 numbers. Numbers must be between 0-100 inclusive.");
		
		int max= Integer.MIN_VALUE;
		int min= Integer.MAX_VALUE;		
		int i = 1;
		while(i <= 5) {
			System.out.print("Enter " + i + ". number: ");
			int num = scanner.nextInt();
			if(num>=0 && num<=100) {		
				if(num > max) {
					max = num;
				}
				if(num < min) {
					min = num;
				}
				i++;
			}else {
				System.out.println("The number you entered is invalid. Number must be between 0-100 inclusive.");
			}
		}
		System.out.println("Max number is: " + max);
		System.out.println("Min number is: " + min);
		
		
		
		scanner.close();
	}
}
