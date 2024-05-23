package com.package1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		
		/* Question: Assign the initial values of 'phone code' and 
		 * 'mail code' (int). Then take phone code and mail code from user
		 * as input. If any of them does not match, give output "phone 
		 * code wrong" or "mail code wrong".
		 * */
		
		// my code:
//		int phoneCode = 549; 
//		int mailCode = 346;
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter phone code: ");
//		int inputPhoneCode = scanner.nextInt();
//		System.out.print("Enter mail code: ");
//		int inputMailCode = scanner.nextInt();
//		
//		if(phoneCode != inputPhoneCode) {
//			System.out.println("The phone code you entered is wrong.");
//		}
//		if(mailCode != inputMailCode) {
//			System.out.println("The mail code you entered is wrong");
//		}
//		if(phoneCode == inputPhoneCode && mailCode == inputMailCode) {
//			System.out.println("You have successfully verified.");
//		}
		
		
		// teacher's code:
		int phoneCode2 = 111; 
		int mailCode2 = 222;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter phone code: ");
		int inputPhoneCode2 = scanner.nextInt();
		System.out.print("Enter mail code: ");
		int inputMailCode2 = scanner.nextInt();
		
		if(phoneCode2 != inputPhoneCode2 && mailCode2 != inputMailCode2) {
			System.out.println("The phone code and mail code you entered are wrong.");
		}else if (phoneCode2 != inputPhoneCode2 && mailCode2 == inputMailCode2) {
			System.out.println("The phone code you entered is wrong.");
		}else if (phoneCode2 == inputPhoneCode2 && mailCode2 != inputMailCode2) {
			System.out.println("The mail code you entered is wrong.");			
		}else {
			System.out.println("You have successfully verified.");
		}
		
			
		
		scanner.close();
	}
}
