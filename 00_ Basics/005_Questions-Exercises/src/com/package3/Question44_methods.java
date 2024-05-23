package com.package3;

import java.util.Scanner;

public class Question44_methods {

	public static void main(String[] args) {
		
/*
 * Bir metot olsun. Metodun içine 2 tane sayı alalım, bu sayıları çarpıp
 * çarpım değerini döndürelim.
 * 
 * Main metodunda bir de bir sayı değeri olsun = 15 olsun.
 * 
 * Bir de sonuç değerimiz olsun = 0; sonuca = metottan dönen değer / sayı
 * 
 * Sonra da sonucu yazdıralım.
 */
		
		int number = 15;
		int result = 0;
//		result = multiply() / number;
//		System.out.println(result);
		
//		int myArr[] = takeInputNumbersFromUserAndReturnAsArray();
//		result = multiply3(myArr);
//		System.out.println(result);
		
		// Or, we can also write like this:
		System.out.println(multiply3(takeInputNumbersFromUserAndReturnAsArray()));
		
		
	}//main ends here
	
	public static int multiply() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a = sc.nextInt();
		System.out.print("Enter second number: ");
		int b = sc.nextInt();
		sc.close();
		return a * b;
	}
	
	public static int[] takeInputNumbersFromUserAndReturnAsArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a = sc.nextInt();
		System.out.print("Enter second number: ");
		int b = sc.nextInt();
		int arr[] = new int[2];
		arr[0] = a;
		arr[1] = b;		
		sc.close();
		return arr;
	}
	
	public static int multiply3(int arr[]) {
		int multiplication = arr[0] * arr[1];
		return multiplication;
		
	}

}//class ends here
