package com.ahmet;

public class Methods8_VarArgs {

	public static void main(String[] args) {
		
		System.out.println("Toplam: " + toplam(1));
		System.out.println("Toplam: " + toplam(1,4));
		System.out.println("Toplam: " + toplam(1,67,23));
		System.out.println("Toplam: " + toplam(1,34, 5, 23, 54));
		System.out.println("Toplam: " + toplam(6, 85, 68, 32, 97, 98, 23));

		
	}//main ends here
	
	public static int toplam(int ...sayilar) { // number of arguments can be whatever you want when you run this method.
		int toplam = 0;
		for(int i=0; i< sayilar.length; i++) {
			toplam += sayilar[i];
		}
		return toplam;
	}

}//class ends here

