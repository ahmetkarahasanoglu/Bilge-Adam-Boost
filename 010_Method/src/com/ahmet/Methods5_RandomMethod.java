package com.ahmet;

import java.util.Random;
import java.util.Scanner;

public class Methods5_RandomMethod {

	public static void main(String[] args) {
		
	/* Question: Make a number guessing game. Computer will
	 * hold a value. If user's guess is above the number, it 
	 * will print "go down". If user's input is below the 
	 * number, it will print "go up".
	 */
		int rastgSayi = rastgeleSayi();
		Scanner sc = new Scanner(System.in);		
		int attempt = 3;
		int[] howMuchCloseArr = new int[attempt];
		int indexForHowMuchCloseArr = 0;
		System.out.println("Number guessing game. You will guess the number by entering numbers between 0-99.");
		do{
			System.out.print("Enter a number: ");
			int input = sc.nextInt();
			attempt--;
			int howMuchCloseCurrent = Math.abs(input-rastgSayi);
			howMuchCloseArr[indexForHowMuchCloseArr] =  howMuchCloseCurrent;
			indexForHowMuchCloseArr++;
			if(input > rastgSayi) {				
				System.out.print("Wrong. ");
				if(attempt > 0) {
					System.out.print("Go down. ");
				}				
				System.out.println("Attempts left: " + (attempt));
			}else if(input < rastgSayi) {				
				System.out.print("Wrong. ");
				if(attempt > 0) {
					System.out.print("Go up. ");
				}				
				System.out.println("Attempts left: " + (attempt));
			}else {				
				System.out.println("Correct. You found the number.");				
				break;
			}			
			if (attempt == 0) {
				System.out.println("You lost. The hold number was: " + rastgSayi);
				System.out.println("The closest difference that you ever reached: " + findMin(howMuchCloseArr));
			}			
		}while(attempt > 0);
		
		
		sc.close();
	}//main sonu
	
	public static int rastgeleSayi() {
		Random random = new Random();
		int sayi = random.nextInt(100); // 0-99 --> generates number between these. 0(inclusive), 99(inlusive), BUT 100 Exclusive.
		return sayi;
	}
	public static int findMin(int arr[]) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
	
}//class sonu
