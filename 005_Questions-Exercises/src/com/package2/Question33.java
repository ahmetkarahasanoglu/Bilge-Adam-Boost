package com.package2;

public class Question33 {

	public static void main(String[] args) {
		
	// Question: find the min and max number in the given array.
		int[] numbers = {0,120,5,85,-256,16,1258,81,14};
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<numbers.length; i++) {			
			if(numbers[i] > max) {
				max = numbers[i];
			}
			if(numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		
		
		

	}
}
