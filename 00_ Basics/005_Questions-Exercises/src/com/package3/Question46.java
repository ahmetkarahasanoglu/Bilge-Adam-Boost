package com.package3;

import java.util.Scanner;

public class Question46 {

	public static void main(String[] args) {
		
	/*
	 * Dışarıdan kaç sayı alacağımızı alalım: 2 veya 3.
	 * Eğer iki gelirse topla() içinde iki değerimizi alıp toplayalım.
	 * Eğer 3 gelirse de bu metodu overlaod şeklinde yazalım. Aldığımız
	 * 3 değeri metoda geçelim.
	 */		
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers do you want to enter: ");
		int numOfInputs = sc.nextInt();
		
		if(numOfInputs == 2) {			
			System.out.println("Total: " + add());
		}else if(numOfInputs == 3) {
			System.out.print("Enter first number: ");
			int num1 = sc.nextInt();
			System.out.print("Enter second number: ");
			int num2 = sc.nextInt();
			System.out.print("Enter third number: ");
			int num3 = sc.nextInt();
			int result = add(num1, num2, num3);
			System.out.println("Total: " + result);
		}
		
		sc.close();
	}//main ends here

	public static int add() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = sc.nextInt();
		System.out.println("Enter second number: ");
		int num2 = sc.nextInt();
		sc.close();
		return num1 + num2;		
	}
	public static int add(int n1, int n2, int n3) {
		return n1 + n2 + n3;		
	}

}//class ends here
