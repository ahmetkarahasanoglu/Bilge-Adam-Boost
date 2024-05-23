package com.package2;

public class Question31 {

	public static void main(String[] args) {
		
		String[] stringArray = new String[4];
		boolean[] booleanArray = new boolean[4];
		booleanArray[0] = false;
		booleanArray[booleanArray.length-1] = true;
		
		boolean[] booleanArray2 = {false, false, true};
		Boolean[] booleanArray3 = new Boolean[1]; // 'Boolean' --> wrapper class
		System.out.println(booleanArray2.length); // 3 
		System.out.println(booleanArray[3]); // true
		booleanArray[3] = false;
		System.out.println(booleanArray[3]); // false
		System.out.println(booleanArray[1]); // false (default initial value)
		System.out.println(booleanArray[2]); // false (default initial value)
		
		System.out.println(booleanArray[0]); // false
		int[] intArray = new int[2];
		Integer[] integerArray = new Integer[2]; // --> wrapper class'lar ile primitive türler (int) farklıdır.
		System.out.println(intArray[1]); // 0 --> the intArray holds primitive int values.
		System.out.println(integerArray[1]); // null --> 'Integer' is a wrapper class. The integerArray holds Reference Type 'Integer' class things.
		
		
		

	}
}
