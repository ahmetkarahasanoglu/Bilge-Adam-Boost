package com.package1;

import java.util.Scanner;

public class Question27 {

	public static void main(String[] args) {
		
	/* Take an input from user. Find out how many 'a's are there in it?
	 * */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter something: ");
		String input = scanner.nextLine();
		
		int numberOfCharacter = 0;
		while(true) {			
			if( input.indexOf("a") != -1) {
				numberOfCharacter += 1;
				input = input.substring(input.indexOf("a")+1);
			}else {
				break;
			}
		}
		System.out.println("There are " + numberOfCharacter + " 'a's in the sentence.");
		
		System.out.println("-------------------------------");
		
		// *********** Teacher's solution *******************
		System.out.print("Enter an input: ");
		String word = scanner.nextLine();
		
		int count = 0;
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) == 'a') {
				count += 1;
			}
		}
		System.out.println("The character 'a' " + count + " times available in the input.");
		
		
		
		
		scanner.close();
	}
}
