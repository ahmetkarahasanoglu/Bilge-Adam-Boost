package com.okulyonetimsistemi;

import java.util.Scanner;

public class OysUtility {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static String stringDegerAlma(String sorgu) {
		System.out.println(sorgu);
		return scanner.nextLine();
	}
	
	public static int intDegerAlma(String sorgu) {
		System.out.println(sorgu);
		return Integer.parseInt(scanner.nextLine());
	}
}
