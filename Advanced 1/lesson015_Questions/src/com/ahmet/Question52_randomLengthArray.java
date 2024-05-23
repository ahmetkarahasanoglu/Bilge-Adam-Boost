package com.ahmet;

import java.util.Random;

public class Question52_randomLengthArray {

	public static void main(String[] args) {
		
		Question52_randomLengthArray obj = new Question52_randomLengthArray();		
		int[] arr = new int[obj.generateRandom()];		
		for(int i=0; i<arr.length; i++) {
			arr[i] = obj.generateRandom();
			System.out.println(arr[i]);
		}
		System.out.println("length: " + arr.length);
		
		obj.boyut1yazdir();

	}//main ends here
	
	public int generateRandom() {
		Random random = new Random();
		int randomNumber = random.nextInt(500);
		randomNumber += 1;
		return randomNumber;
	}
	
	public void boyut1yazdir() {
		int boyut1 = generateRandom();
		System.out.println(boyut1);
	}

}//class ends here
