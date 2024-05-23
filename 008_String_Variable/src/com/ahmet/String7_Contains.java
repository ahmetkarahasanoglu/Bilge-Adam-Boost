package com.ahmet;

public class String7_Contains {

	public static void main(String[] args) {
		
		/* .contains() --> checks if string contains a specified word or sentence etc.
		 */
		String str = "Today the teacher is giving a lecture about String class.";
		System.out.println(str.contains("teacher")); // true
		
		/* .startsWith()
		 * .endsWith()
		 * '--> check if a string starts or ends with a specified word or sentence etc.
		 * 
		 * Example (startsWith): imagine that we have product codes. We want to get
		 * monitor (screen) products.
		 */
		String stock1 = "STKPC4451";
		String stock2 = "STKMNT522"; // -> this is monitor. It starts 
									 //    with "STKMNT" code.
		System.out.println("Is stock1 monitor?: " + stock1.startsWith("STKMNT"));
		System.out.println("Is stock2 monitor?: " + stock2.startsWith("STKMNT"));
		System.out.println();
		
		
		/* Example (endsWith): We have a list of filenames. We want to get only
		 * the files with '.java' extension.
		*/ 
		String doc1 = "wedding.mp4";
		String doc2 = "MainStorage.java";
		
		System.out.println("Is doc1 a java file?: " + doc1.endsWith(".java"));
		System.out.println("Is doc2 a java file?: " + doc2.endsWith(".java"));
		 
		
		
		
		
		
	}
}
