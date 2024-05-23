package com.ahmet;

public class String1 {
	
	private static int num3; // here, the int-type num2 can be used
							 // [although its' a primitive type -'int'-] without
							 // initializing it (assigning value to it).
							 // It's because of 'static' keyword. Static keyword gives an address to variable.
							 // When we print num3, we will see --> 0

	public static void main(String[] args) {
		
		/* - Primitive Data Type -->  (int etc.)
		 * - Reference Data Type --> Java classes
		 * String --> "today weather is beautiful"
		 * There is no restriction in terms of memory for References Data
		 * types (like String). Example: we can write a "million-character-
		 * string". These types can expand as long as the heap memory area.
		 * # IMPORTANT !!!: Primitive data types (like int) can't be 
		 * initialized as empty (null).
		 * # IMPORTANT !!!: Reference data types can be initialized 
		 * as empty (null).
		 * */
		int num1; // cannot be used without initializing it first (assigning value to it). Because it's address section has no address. Initializing it, gives an address to it.
		int num2 = 5;
		String text1 = null; // Here, there is no memory area that is pointed in heap area. /// We can Ctrl+Click on 'String' and see its specifications.
		String text2 = ""; // Here, there is an addressed place in the heap, but it has an empty value. Empty string is different than 'null'
		String text3 = "hello";
		
//		System.out.println(num1); // 'num1 was not initialized'
		System.out.println(num2);		
		System.out.println(num3); // thx to static keyword; although num3 was not initialized (assigned a value), it runs here without any error. 
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
		
		String xxx = text1 + "fgsgg";		
		text1 = text1 + "kjhnhgh";
		
		
		

		
		
	}
}
