package com.package2;

public class Question34 {

	public static void main(String[] args) {
		
	// Find the second greatest number in the given array.		
		// ***** MY SOLUTION: *****
		int[] numbers = {0,120,5,85,-256,16,1258,81,14};		
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
			if(numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		// -------
		
		int maxSecond = Integer.MIN_VALUE;
		int minSecond = Integer.MAX_VALUE;
		
		for(int i=0; i < numbers.length; i++) {
			if(numbers[i] != max) {
				if(numbers[i] > maxSecond) {
					maxSecond = numbers[i];
				}
			}
			if(numbers[i] != min) {
				if(numbers[i] < minSecond) {
					minSecond = numbers[i];
				}
			}			
		}
		if(maxSecond == Integer.MIN_VALUE) {
			System.out.println("There is no second max.");  
		}else {
			System.out.println("Second max: " + maxSecond);
		}
		if(minSecond == Integer.MAX_VALUE) {
			System.out.println("There is no second min.");
		}else {
			System.out.println("Second min: " + minSecond);
		}
		
		// ****** CHAT-GPT's SOLUTION ******
//		int[] numbers = {0, 120, 5, 85, -256, 16, 1258, 81, 14};
//
//        int max = Integer.MIN_VALUE;
//        int secondMax = Integer.MIN_VALUE;
//
//        for (int number : numbers) {
//            if (number > max) {
//                secondMax = max;
//                max = number;
//            } else if (number > secondMax && number != max) {
//                secondMax = number;
//            }
//        }
//
//        if (secondMax == Integer.MIN_VALUE) {
//            System.out.println("There is no second greatest number.");
//        } else {
//            System.out.println("The second greatest number is: " + secondMax);
//        }
		
		
		
		
	}
}
