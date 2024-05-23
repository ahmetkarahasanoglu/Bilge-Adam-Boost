package com.ahmet;

public class Question4 {

	public static void main(String[] args) {
		
		// Soru: İki tane string değişkenimiz olsun: isim, soy isim.
		// Bunları başka bir değişkene atayıp ekrana yazdıralım
		
		String name = "John";
		String lastName = "Smith";
		String fullName= name + " " + lastName;
		System.out.println(fullName);		
		// Not: /n (enter karakteri), /t (tab karakteri): string'ler 
		// içerisinde kullanılır, string'den kaçış için kullanılır, ilgili
		// boşluk karakterlerini sağlarlar.
		
		// Soru: a ve b karakterlerinin toplamını ekrana yazdıralım.
		char a = 'a';
		char b = 'b';		
		System.out.println(a + b);
		
	}

}
