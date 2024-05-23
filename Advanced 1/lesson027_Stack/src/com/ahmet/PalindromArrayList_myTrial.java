package com.ahmet;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromArrayList_myTrial {

	public static void main(String[] args) {
		
		PalindromArrayList_myTrial objOfThisClass = new PalindromArrayList_myTrial();
		
		ArrayList<String> arrayList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a text: ");
		String text = scanner.nextLine();
		for(int i=0; i<text.length(); i++) {
			arrayList.add((text.charAt(i) + "").toLowerCase());
		}
		
		System.out.println("Is the text palindrome: " + objOfThisClass.isPalindrome(arrayList));
		scanner.close();

	}//MAIN ENDS HERE ---------
	
	public boolean isPalindrome(ArrayList<String> arrList) {
		ArrayList<String> reverseArrayList = makeReverseArray(arrList);		
		for(int i=0; i<arrList.size(); i++) {
			if(!arrList.get(i).equals(reverseArrayList.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<String> makeReverseArray(ArrayList<String> arrList) {
		ArrayList<String> ReverseArrayList = new ArrayList<>();
		for(int i=arrList.size()-1; i>=0; i--) {
			ReverseArrayList.add(arrList.get(i));
		}
		return ReverseArrayList;
	}

}//CLASS ENDS HERE -------
