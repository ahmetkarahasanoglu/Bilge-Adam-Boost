package com.package2;

public class Wrapper_Classes {

	public static void main(String[] args) {
	
	/* WRAPPER CLASSES
	 * For example; instead of int, we can use Integer. Integer
	 * is a wrapper class. And by using it, our variable becomes
	 * a Reference Type variable. Not primitive type variable.	 * 
	 */

		int referenceTypeNumber = Integer.MAX_VALUE; /* By using 
		Integer, we can use its methods like MAX_VALUE.
		*/
		
		int primitiveTypeVariable = null; // this cannot be null. Because it is a primitive type. It can only be an integer number, not null. It is stored in the STACK memory. 
		Integer ReferenceTypeVariable = null; // this can be null. Because is a Reference Type. It is stored in the HEAP memory.
	}

}
