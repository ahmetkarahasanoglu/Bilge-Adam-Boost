package com.ahmet;

public class Methods9_practice_VarArgs {

	public static void main(String[] args) {
		
		/*
		 * Bir ifademiz olsun. Bunun içine bilgiler girmek 
		 * isteyelim
		 */
		int s1=14;
		int s2=91;
		int s3=444;
		int toplam = s1+s2+s3;
		// 14 sayısı ile 91 sayısının toplamı 105'tir.
		System.out.println(s1 + " sayısı ile " + s2 + " sayısının toplamı " + toplam + "'dır.");
		ekranaYaz("{1} sayısı ve {2} sayısı ve {3} sayısının toplamı {4} tür.", s1,s2,s3,toplam);

	}//main ends here
	
	static void ekranaYaz(String ifade, int... sayilar) {
		for(int i=0; i<sayilar.length; i++) {
			ifade = ifade.replace("{"+(i+1)+"}", sayilar[i]+"");
		}
		System.out.println(ifade);
	}

}//class ends here
