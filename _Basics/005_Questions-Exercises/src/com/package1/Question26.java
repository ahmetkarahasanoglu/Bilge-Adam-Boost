package com.package1;

import java.util.Scanner;

public class Question26 {

	public static void main(String[] args) {
		
	/* Take an input from the user. Print each letter with their index
	 * number before them. Print them one below another.
	 * */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter something: ");
		String input = scanner.nextLine();
		
		for(int i=0; i<input.length(); i++) {
			System.out.println(i + " " + input.charAt(i));
		}

		
		
		scanner.close();
	}
}
