package com.package2;

public class Question40 {

	public static void main(String[] args) {
		
	/* Bir başlangıç ve bitiş değeri arasındaki sıralı sayılardan, eğer
	 * sayı 3'ün katı ise "bilge", 5'in katı ise adam, hem 3'ün hem 5'in
	 * katı ise "bilgeadam" yazdıralım. (başlangı=2, bitiş=22 olsun)
	 */
		
		String resultText = "";
		
		for(int i=2; i<=22; i++) {
			if(i%3==0 && i%5==0) {
				resultText += i + " bilgeadam";
			}else if(i%3==0) {
				resultText += i + " bilge";
			}else if(i%5==0) {
				resultText += i + " adam";
			}else {
				resultText += i;
			}
			resultText += ", ";
		}
		System.out.println(resultText);
		

	}
}
