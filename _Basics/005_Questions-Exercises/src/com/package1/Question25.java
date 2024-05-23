package com.package1;

public class Question25 {

	public static void main(String[] args) {
		
		String value = "  Hello World  ";
		String value2 = "Hello World";
		String value3 = "Hello World";
		
		System.out.println(value.charAt(2)); // H
		System.out.println(value.trim()); 	// Hello World
		System.out.println(value.length()); // 15
		System.out.println(value.indexOf("e")); // 3
		System.out.println(value.lastIndexOf("l")); // 11
		System.out.println(value.substring(5)); // lo World
		System.out.println(value.substring(3, 6)); // ell
		System.out.println(value.equals("Hello World")); // false
		System.out.println(value.equals("  Hello World  ")); // true (compares the content)
		System.out.println(value == "  Hello World  "); // true (the two thing points to the same place in memory. It's because of the pool thing.)
		System.out.println(value.trim() == value2); // false (when trimmed, it points to another place [I guess]).
		System.out.println(value3 == value2); // true

		
	}
}
