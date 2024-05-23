package com.ahmet;

import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * dışarıdan bir metin gireceğiz sonra bu metini bir stack e atayacagız
 * 
 * daha sonrada palindrom olup olmadıgını kontrol eden metodu yazalım 
 * 
 * 
 */
public class PalindromStrack_tchrsCode {

	Stack<Character> stack = new Stack<>();

	public static void main(String[] args) {
		PalindromStrack_tchrsCode palindromStack = new PalindromStrack_tchrsCode();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen bir kelime giriniz");
		String kelime = scanner.nextLine();

		if (palindromStack.isPalindrom(kelime)) {
			System.out.println(kelime + " Palindromdur");
		} else {
			System.out.println(kelime + " Palindrom değildir !!!");
		}

	}//MAIN ENDS HERE ---------
	
	public boolean isPalindrom(String kelime) {
		stackOlusturma(kelime);
		for (int i = 0; i < kelime.length() / 2; i++) {
			if (kelime.charAt(i) != stack.pop()) {
				return false;
			}
		}
		return true;
	}

	public void stackOlusturma(String kelime) {
		for (int i = 0; i < kelime.length(); i++) {
			stack.push(kelime.charAt(i));
		}
//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//
//		}
	}

	
}//CLASS ENDS HERE ----------
