package com.ahmet;

import java.util.Locale;
import java.util.Scanner;

public class String4 {

	public static void main(String[] args) {
		
		// TOPICS: .toUpperCase(), .toLowerCase()
		
	/* When logging in somewhere, it doesn't matter to write the username 
	 * as lowercase or uppercase. But for password, it's important. 
	 * # The language of the PC is important to consider for this;
	 *   i -> I (eng)
	 *   i -> İ (tr)
	 *   
	 *   .toUpperCase(Locale.ENGLISH) -> Makes it uppercase with english caracters.
	 *   .toUpperCase(Locale.forLanguageTag("tr-TR")); -> uppercase Turkish
	 *   .toUpperCase(Locale.ROOT) -> machine's language
	 */
		String str = "I'm gonna go outside today.";
		System.out.println(str.toUpperCase(Locale.ENGLISH));
		str = "Today THE WEATHER feels like HOT.";
		System.out.println(str.toLowerCase());
		
		str = "iüŞ";
		System.out.println(str.toUpperCase(Locale.ENGLISH));
		System.out.println(str.toUpperCase(Locale.ROOT));
		System.out.println(str.toUpperCase(Locale.forLanguageTag("tr-TR")));
		
		String username = "ahmet";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username: ");		
		String inputUsername = scanner.nextLine().toLowerCase();		
//		if(username.toLowerCase().equals(inputUsername.toLowerCase())) {  // or, we can use 'equalsIgnoreCase()' as shown below. 
		if(username.equalsIgnoreCase(inputUsername)) {
			System.out.println("Username is correct.");
		} else {
			System.out.println("Username is NOT correct.");
		}
		

		
		
		
		scanner.close();
	}
}
