package com.ahmet;

import java.util.Scanner;

public class String2 {

	public static void main(String[] args) {
		
		/* TOPICS OF THIS FILE:
		 * .length(), .charAt(), .indexOf(),
		 * .lastIndexOf(), substring(), trim()
		 */
		
		String myText = "  Hi, how is    it   going?   ";
		System.out.println(myText.length());
		System.out.println(myText.charAt(25));
		System.out.println("2)-------------------------");

	// Question: Print your name, each letter on a separate line.
		String name = "Ahmet";
		for(int i=0; i<name.length(); i++) {
			System.out.println(name.charAt(i));
		}
		System.out.println("3)-------------------------");
		
	// Question: Print your name in reverse.
		name = "Ahmet";
		for(int i=name.length()-1; i>=0; i--) {
			System.out.println(name.charAt(i));
		}
		System.out.println("4)-------------------------");
		
	// Question: Find the index of 'e' character.
		System.out.println(name.indexOf("e"));
		System.out.println("5)-------------------------");
		
	// Question: Find where the expression "met" is used in the String expression.
		System.out.println(name.indexOf("met"));
		System.out.println("6)-------------------------");
		
	// Question: Cut a part from a String value from specific points and
	// 			 make a new string from this part.
		String text = "Let's go hang out.";
		System.out.println(text.substring(9, 13)); // 9 inclusive, 13 not inclusive
		System.out.println(text.substring(9));
		System.out.println("7)-------------------------");
		
	// Question: Classify some files according to their extensions.
		String file1 = "wedding picture.jpg";
		String file2 = "returning video from holiday.mp4";
		String file3 = "business notes.docx";
		
		int index_of_dot = file1.lastIndexOf(".");
		String extension1 = file1.substring(index_of_dot+1);
		System.out.println("Extension of file1: " + extension1);
		
		index_of_dot = file2.lastIndexOf(".");
		String extension2 = file2.substring(index_of_dot+1);
		System.out.println("Extension of file2: " + extension2);
		
		index_of_dot = file3.lastIndexOf(".");
		String extension3 = file3.substring(index_of_dot+1);
		System.out.println("Extension of file3: " + extension3);
		System.out.println("8)-------------------------");
		
	/* Question:
	 * username: "admin";
	 * password: "12345";
	 * 
	 * Note: You can use trim() to remove the spaces at the very 
	 * beginning and very end of the String text.
	 * */
		String username = "admin";
		String password = "12345";
		if(username.trim() == "admin" && password == "12345") {
			System.out.println("You successfully signed in.");
		} else {
			System.err.println("Username or password is wrong.");
		}
		System.out.println("9)-------------------------");
		
	/* Exercise: Login Page
	 * Note: You can use trim() to remove the spaces at the very 
	 * beginning and very end of the String text.
	 * 
	 * ###### IMPORTANT !!!!!!! : When checking if two Reference Type
	 * variables (like String) are equal to each other, we must not
	 * use '=='. We must use ex:  text1.equals(text2).  Because '=='
	 * compares the addresses of the to variables. But what we need
	 * is to compare the values of the variables. 
	 * */
		String email = "ahmet@gmail.com";			
		password = "123";		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*****************************");
		System.out.println("***** MUSTERI OTOMASYON *****");
		System.out.println("********** LOGIN ************");
		System.out.println("*****************************");	
		System.out.println();
		
		System.out.print("Enter your username: ");
		String usr = scanner.nextLine();
		System.out.print("Enter your password: ");
		String pwd = scanner.nextLine();
		
		if(usr.equals(email) && pwd.equals(password)) {
			System.out.println("You have successfully signed in.");
		}else {
			System.out.println("Username or password is wrong.");
		}
		
		

		
		
		scanner.close();
	}
}
