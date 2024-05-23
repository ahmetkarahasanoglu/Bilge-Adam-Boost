package com.ahmet;

public class String6_practice {

	public static void main(String[] args) {
		
		/* Question: We need to modify the name of a file to use it as 
		 * a link.
		 * 
		 * Filename: "2022 yılı en yüksek değere sahip uygulamaları.xlsx
		 *    Use '-' instead of space character.
		 *    Convert Turkish characters to English.		  
		 */
		String fileName = "2022 yılı en yüksek değere sahip uygulamaları.xlsx";
		
		fileName = fileName.replace(" ", "-")
						   .replace("ç", "c")
						   .replace("ğ", "g")
						   .replace("ı", "i")
						   .replace("ö", "o")
						   .replace("ş", "s")
						   .replace("ü", "u");
		
		System.out.println(fileName);
		
		

		
		
		
		
		
		
	}
}
