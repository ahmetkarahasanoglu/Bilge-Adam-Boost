package com.package2;

import java.util.Scanner;

public class Question32 {

	public static void main(String[] args) {
		
	/*
	 * Question: Write the code that finds out the entered country as input
	 * is available in the countries that we have. Print if the country
	 * is available or not
	 */
		String[] availableCountries = {"Türkiye", "Japonya", "Moğolistan", "Fransa", "Danimarka"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ülke giriniz: ");
		String inputCountry = sc.nextLine();
		boolean isFound = false;
		for(int i=0; i<availableCountries.length; i++) {
			if(availableCountries[i].equals(inputCountry)) {
				isFound = true;
			}
		}
		if (isFound) {
			System.out.println("The country is available.");
		}else {
			System.out.println("The country is NOT available.");
		}
		
		
	}
}
