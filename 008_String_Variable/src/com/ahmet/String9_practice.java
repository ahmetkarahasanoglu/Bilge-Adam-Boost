package com.ahmet;

import java.util.Locale;

public class String9_practice {

	public static void main(String[] args) {
		
		/* Question: Make firstName and lastName variables. Assign your
		 * name to them. On the output; show the firstName's first letter 
		 * as capital letter and other letters of it as small letters. And
		 * show all the letters of lastName as capital letters.
		 */
		String firstName = "john";
		String lastName = "Smith";
		
		System.out.println("First name and last name: " + 
				firstName.replace("j", "J") + " " + lastName.toUpperCase(Locale.ENGLISH));
						// '--> replace() is not a proper usage here, because it replaces all the "j" letters to "J" in the name.
		
		// Second Way:
		System.out.println("******** Second Way: **********");
		String firstNameArray[] = firstName.split("");
		String firstNameDisplay = "";
		for(int i=0; i<firstName.length(); i++) {
			if(i==0) {
				firstNameDisplay += firstNameArray[i].toUpperCase(Locale.ENGLISH);
			}else {
				firstNameDisplay += firstNameArray[i].toLowerCase();
			}
		}
		String lastNameDisplay = lastName.toUpperCase(Locale.ENGLISH);
		System.out.println(firstNameDisplay + " " + lastNameDisplay);
				
		// Third Way:
		System.out.println("******** Third Way: **********");
		System.out.println(firstName.substring(0,1).toUpperCase(Locale.ENGLISH)
				+ firstName.substring(1).toLowerCase()
				+ " " + lastName.toUpperCase(Locale.ENGLISH)
		);
				
				
		

	}
}
