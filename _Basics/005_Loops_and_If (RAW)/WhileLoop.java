package com.ahmet;

public class WhileLoop {

	public static void main(String[] args) {
		
		// print the odd numbers starting from fifty, going down to 0.
		for(int i=25; i>0; i=i-2) {
			System.out.println(i);
		}

		// WHILE LOOP
		int i=0;
		while(i<5) {
			i++;
			System.out.println("While loop ran.");
		}
		// While loop exercise: Among the numbers that
		// are greater than 300; print the numbers until reaching the 
		// number that is divisible by 25.
		i=301;
		while(i % 25 != 0) {
			i++;
		}
		System.out.println(i);	
		
		
		
		
	}
}
