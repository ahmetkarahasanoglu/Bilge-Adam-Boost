package com.package1;

import java.util.Scanner;

public class Question15 {

	public static void main(String[] args) {
		
		/* Question: Keep reading number inputs from user until user
		 * enters 0. Print the sum of those numbers, and average. 
		 * */
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Enter the numbers one by one. [Press 0 to terminate and see the total and average]: ");		
		int total = 0;
		int count = 0;
		int currentInput;		
		do{			
			currentInput = scanner.nextInt();
			count++;
			total = total + currentInput;
		}while(currentInput != 0);
		
		count = count - 1;				 
		int average = total / count;
		System.out.println("Total: " + total + ". Average: " + average );
		
		
		scanner.close();
	}
}
