package com.ahmet;

public class Runner_Number_Example {

	public static void main(String[] args) {
		int integerNumber = 23;
		float decimalNumber;

		decimalNumber = integerNumber;
		System.out.println("Assigned decimal number: " + decimalNumber); // 23.0

		decimalNumber = 23.9f;
//		integerNumber = decimalNumber; // Error: Type mismatch: cannot convert from float to int
		System.out.println("Casted number(float to integer): " + (int) decimalNumber); // 23 || casted number (converted)
		
		// **** CHAR ****
		char karakter;
		karakter = 65;
		System.out.println("65'nin karakter çıktısı: " + karakter); // 'A' (65'in karakter çıktısı)
		karakter = 'E'; // tek tırnak kullanılmalı (char atarken)
		System.out.println("2.yöntem: char olarak 'E' yazdık: " + karakter );
		System.out.println("Casted(converted): " + (char)75);
		
	}
}
