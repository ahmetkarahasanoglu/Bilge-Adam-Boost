package com.ahmet;

import java.util.Scanner;

public class String5_Replace {

	public static void main(String[] args) {
		
		/* replace() method enables us to change (replace) some words
		 */
		String contract = "This contract has been signed between [A] and"
				+ " [B] for the amount of [Price] on the date of [Date].";
		Scanner scanner = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println("***** PREPARING RENT CONTRACT *****");
		System.out.println("************************************");
		System.out.println();
		System.out.print("Enter the name of landlord: ");
		String landlord = scanner.nextLine();
		System.out.print("Enter the name of tenant (the person who rents): ");
		String tenant = scanner.nextLine();
		System.out.print("Enter the rent price: ");
		String price = scanner.nextLine();
		System.out.print("Enter the date of contract: ");
		String date = scanner.nextLine();
		
		String newContract = contract.replace("[A]", landlord)
							  .replace("[B]", tenant)
							  .replace("[Price]", price)
							  .replace("[Date]", date);
		
		System.out.println(newContract);
		

		
		
		
		
		scanner.close();
	}
}
