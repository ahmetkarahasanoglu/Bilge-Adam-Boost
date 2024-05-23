package com.package1;

public class Question14 {

	public static void main(String[] args) {
		
		// Question: Print the alphabet from a to z.
		// my solution:
		char initialLetter = 'a';
		for(int i=0; i<26; i++) {
			System.out.println((char)(initialLetter + i));
		}
		// teacher's solution:
		char harf;
		for(harf='a'; harf<='z'; harf++) {
			System.out.print(harf + " ");
		}
		
	}
}
