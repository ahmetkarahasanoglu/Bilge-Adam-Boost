package com.ahmet;

public class Methods10_VarArgs_myPrac1 {
	
	public static int add(int... numbers) {
		int total = 0;
		for(int i=0; i<numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}
	public static int subtract(int... numbers) { // use the first number as the initial value and subtract the rest
		int result = numbers[0];
		for(int i=1; i<numbers.length; i++) {
			result -= numbers[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(add(2,4,6,8));
		System.out.println(subtract(30, 3, 5, 7, 6));

		
		
	}//main ends here	

}//class ends here
