package com.ahmet;

public class String3 {

	public static void main(String[] args) {
		
		String name1 = "Ahmet";
		String name2 = "Ahmet";
		
		if(name1.trim() == name2) {
			System.out.println("The two expressions are equal."); // Output: equal
		}else {
			System.out.println("NOT equal.");
		}
		/* '--> Output is 'equal'. Because; if the values of the two 
		 * variables are same, Java saves them in 1 place in memory, to save from 
		 * memory space. In other words, the addresses of name1 and name2
		 * points to the same place in the memory.
		 * 		#### But remember: we should use text1.equals(text2) 
		 * when comparing two Reference Type variables (like String).
		 * */
		
		
		
	/* Question: Print out Ahmet like this:
	 * A
	 * Ah
	 * Ahm
	 * Ahme
	 * Ahmet
	 * Ahme
	 * Ahm
	 * Ah
	 * A
	 */
		String name = "Ahmet";
		for(int i=1; i<=name.length(); i++) {
			System.out.println(name.substring(0,i));			
		}
		for(int i=name.length()-1; i>=0; i--) {
			System.out.println(name.substring(0,i));
		}
		
	

	}
}
