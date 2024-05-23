package com.ahmet;

import java.util.Scanner;

public class Methods4_practice {

	public static void main(String[] args) {
		
//		System.out.println("Alınan sayı: " + sayiAl("Bir sayı giriniz: "));

		String input = takeInput("Enter an expression: ");
		System.out.println(input.charAt(0) + "" + input.charAt(input.length()-1) );
		
		
	}//main sonu
	
	public static int sayiAl(String ifade) {
		System.out.println(ifade);
		Scanner sc = new Scanner(System.in);
		int sayi = sc.nextInt();	
		sc.close();
		return sayi;
	}
	
	public static String takeInput(String requestExpression) {		
		Scanner sc = new Scanner(System.in);
		System.out.print(requestExpression);
		String input = sc.nextLine();
		sc.close();
		return input;
	}
	
}//class sonu
