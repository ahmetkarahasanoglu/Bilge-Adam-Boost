package com.package3;

import java.util.Scanner;

public class Question45_methods_Replace_used {

	public static void main(String[] args) {
		
	/*
	 * Türkçe karakterleri İngilizce karakterlere çeviren metot.
	 * Bir metot array'lerimizin 2'sini de alsın.
	 * Daha sonra metodun içinde input olarak bir string değer alalım.
	 * Sonra Türkçe karakterlerin İngilizce karakterlere dönüştürülmüş
	 * halini geri döndürelim.
	 * Döndüğümüz string değerini main metodunda yazdıralım.
	 */
		String[] ingilizceKarakterler = { "I", "i", "s", "S", "c", "C", "g", "G", "u", "U", "o", "O" };
		String[] turkceKarakterler    = { "İ", "ı", "ş", "Ş", "ç", "Ç", "ğ", "Ğ", "ü", "Ü", "ö", "Ö" };
		
		String strWithEngCharacters = convertToEngCharacters(turkceKarakterler, ingilizceKarakterler);
		System.out.print(strWithEngCharacters);

	}//main ends here
	
	public static String convertToEngCharacters(String[] trCharsArr, String[] engCharsArr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string expression: ");
		String input = sc.nextLine();
//		for(int i=0; i<input.length(); i++) {
//			for(int j=0; j<trCharsArr.length; j++) {
//				if((input.charAt(i)+ "").equals(trCharsArr[j])) {
//					input = input.replace(input.charAt(i)+"", engCharsArr[j]);
//				}
//			}
//		}
		// or, instead of double 'for', we can do it like this:
		for(int i=0; i<trCharsArr.length; i++) {
			input = input.replace(trCharsArr[i], engCharsArr[i]);
		}
		
		sc.close();
		return input;
	}

}//class ends here
