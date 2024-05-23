package com.ahmet;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("**** MIN AND MAX VALUES OF NUMBER VARIABLES: ****");
		System.out.println("**************************************");
		System.out.println("Byte.MIN_VALUE:....[8-bit]:  " + Byte.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE:....[8-bit]:  " + Byte.MAX_VALUE);
		System.out.println("Short.MIN_VALUE:...[16-bit]: " + Short.MIN_VALUE);
		System.out.println("Short.MAX_VALUE:...[16-bit]: " + Short.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE:.[32-bit]: " + Integer.MIN_VALUE);
		System.out.println("Integer.MAX_VALUE:.[32-bit]: " + Integer.MAX_VALUE);
		System.out.println("Long.MIN_VALUE:....[64-bit]: " + Long.MIN_VALUE);
		System.out.println("Long.MAX_VALUE:....[64-bit]: " + Long.MAX_VALUE);
		System.out.println("Float.MIN_VALUE:...[32-bit]: " + Float.MIN_VALUE + "       [32-bit floating-point number]");
		System.out.println("Float.MAX_VALUE:...[32-bit]: " + Float.MAX_VALUE + "   [32-bit floating-point number]");
		System.out.println("Double.MIN_VALUE:..[64-bit]: " + Double.MIN_VALUE + "        [64-bit floating-point number]");
		System.out.println("Double.MAX_VALUE:..[64-bit]: " + Double.MAX_VALUE + "   [64-bit floating-point number]");
		System.out.println("boolean: 'true', 'false'");
		System.out.println("char:  16-bit Unicode character ('\\u0000' to '\\uffff' or 0 to 65,535)");
		System.out.println("--------------------------------------------------");

		/*
		 * Sayılarda yazarken okunabilirliği arttrımak için alt çizgi kullanılabilir
		 * (_). Örnek:
		 */
		long uzunTamsayi = 40_147_774_010_144L; // Çıktıda alt çizgiler görünmez.

		System.out.println("**** ASSIGNING VARIABLE TO ANOTHER VARIABLE (OF WHICH TYPES ARE DIFFERENT");
		int intValue = 10; // Declaring an int variable
		double doubleValue; // Declaring a double variable

		// Assigning int value to double variable (implicit conversion)
		doubleValue = intValue; // Implicit casting (no explicit casting needed -widening conversion-)

		System.out.println("intValue: " + intValue);
		System.out.println("doubleValue: " + doubleValue);

		// Assigning double value to int variable (explicit casting needed)
		doubleValue = 20.5; // A double value
		intValue = (int) doubleValue; // Explicit casting from double to int (narrowing conversion)

		System.out.println("doubleValue: " + doubleValue);
		System.out.println("intValue after casting: " + intValue);
		// how to find out the type of a variable (I looked it up on internet):
		System.out.println(((Object) doubleValue).getClass().getSimpleName());
		/*
		 * NOTE: . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
		 * - 234.854f --> represents a float literal. . . . . . . . . . . . . . . . . .
		 * - (float) 234.854 --> this is a conversion syntax; a double value is
		 * converted to a float value. (default type of it was 'double')
		 */
	}

}
