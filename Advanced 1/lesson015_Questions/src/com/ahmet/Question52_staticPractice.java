package com.ahmet;

import java.util.Random;
/*
 * 1) Bir static olmayan metot yazacağız.
 * Bu metot bize random bir sayı üretip dönecek.
 * Daha sonra main metot'ta biz bu sayıyı boyut1'e eşitleyelim.
 * Ve boyut2 için de bir random sayı oluşturalım. 
 * 
 * 2) static bir metot yazalım. string değerimizi içeride değiştirip geri 
 * döndürelim.
 */

public class Question52_staticPractice {
	
	int boyut1;
	static int boyut2;
	String deger = "this is initial value of deger.";

	public static void main(String[] args) {
		
	/*
	 *  1) Bir static olmayan metot yazacağız.
	 *	Bu metot bize random bir sayı üretip dönecek.
	 *	Daha sonra main metot'ta biz bu sayıyı boyut1'e eşitleyelim.
	 *	Ve boyut2 için de bir random sayı oluşturalım.
	 */
		Question52_staticPractice obj = new Question52_staticPractice();		
		
		obj.boyut1 = obj.randomSayiUret();
		System.out.println("boyut1: " + obj.boyut1);
		
		boyut2 = obj.randomSayiUret();
		System.out.println("boyut2: " + boyut2);
		
		obj.boyut2 = obj.randomSayiUret();
		System.out.println("boyut2: " + boyut2);
		
		Question52_staticPractice.boyut2 = obj.randomSayiUret();
		System.out.println("boyut2: " + boyut2);
		
	/*
	 * 2) static bir metot yazalım. En yukarda class'da tanımladığımız 
	 * string değerimizi parametre olarak metoda gönderip metot 
	 * içerisinde değiştirip geri döndürelim.
	 */
		System.out.println(obj.deger);		
		obj.deger = statikMetot("aaaaa");
		System.out.println(obj.deger);

	}//main ends here
	
	public int randomSayiUret() {
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		randomNumber += 1;
		return randomNumber;		
	}
	
	public static String statikMetot(String str) {		
		str = "metot içerisinde atanan text";
		return str;
	}

}//class ends here


