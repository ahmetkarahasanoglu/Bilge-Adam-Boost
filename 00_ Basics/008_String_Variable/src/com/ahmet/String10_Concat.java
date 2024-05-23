package com.ahmet;

public class String10_Concat {

	public static void main(String[] args) {
		
		/* .concat() : is used to add string to another string. Its 
		 * 			benefit is; it doesn't create an object, so it doesn't
		 * 			occupy extra place on the memory, unlike combining
		 * 			strings like this:  str1 + "another string" 
		 * 
		 */
		String str = "Today weather is nice.";
		System.out.println(str + "another string"); // occupies extra memory (it creates a new object for "another string")
		System.out.println(str.concat("another string")); // good. doesn't occupy extra memory.
		
		System.out.println("---------------");
		
		
		/* isEmpty() : checks if it is an empty string or not ("").
		 * isBlank() : return true if it is an empty string or if it has 
		 * 				white space characters.
		 */
		String emptyString = "";
		String spaceCharacterString = " ";
		System.out.println("1) is blank?: " + emptyString.isBlank());
		System.out.println("2) is blank?: " + spaceCharacterString.isBlank());
		System.out.println("3) is empty?: " + emptyString.isEmpty());
		System.out.println("4) is empty?: " + spaceCharacterString.isEmpty());
		
		
		

	}
}
