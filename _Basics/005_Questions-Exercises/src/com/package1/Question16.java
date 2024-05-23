package com.package1;

public class Question16 {

	public static void main(String[] args) {
		
		/* Soru: Find the sum of odd numbers and sum of even numbers 
		 * between 1-100. And find the ratio of sumOfEvens to sumOfOdds.		 * 
		 * */
		double sumOfOdds = 0;
		double sumOfEvens = 0;
		for(int i=1; i<100; i=i+2) {
			sumOfOdds = sumOfOdds + i;
			sumOfEvens = sumOfEvens + i+1;
		}
		System.out.println(sumOfEvens);
		System.out.println(sumOfOdds);
		System.out.println(sumOfEvens / sumOfOdds);

	
	}
}
