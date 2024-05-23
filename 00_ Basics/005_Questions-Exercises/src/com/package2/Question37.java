package com.package2;

public class Question37 {

	public static void main(String[] args) {
		
	/*
	 * Aşağıda verilen dizi içerisinde 1 ve 4 kaç kere geçtiğini 
	 * bulan ve 1'lerin adeti 4'lerin adedinden büyükse true,
	 * değilse false veren kodu yazın.
	 */
		int[] sayilar = { 1,4,5,6,1,1,4,8 };
		int countOf1 = 0;
		int countOf4 = 0;
		for(int i=0; i<sayilar.length; i++) {
			if(sayilar[i] == 1) {
				countOf1++;
			}else if(sayilar[i] == 4){
				countOf4++;
			}
		}
		if(countOf1 > countOf4) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		System.out.println("1 sayisi " + countOf1 + " tane vardir.");
		System.out.println("4 sayisi " + countOf4 + " tane vardir.");
		
	}
}
