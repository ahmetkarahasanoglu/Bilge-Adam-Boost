package com.package1;

public class Question23 {

	public static void main(String[] args) {
		
		/* Perfect number: is a number for which the sum of its positive 
		 * divisors, excluding itself, equals the number itself.
		 * */
		// For between 1-10.000:
		for(int i=1; i<=10000; i++) {			
			int sumOfPositiveDivisors = 0;
			
			for(int divisor=1; divisor<=i/2; divisor++) {				
				if(i%divisor == 0) {
					sumOfPositiveDivisors += divisor;
				}
			}
			if(i == sumOfPositiveDivisors) {
				System.out.println(i + " is a perfect number.");
			}
		}		
		
		
		
		
	}
}
