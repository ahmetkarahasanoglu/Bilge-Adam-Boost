package com.ahmet;

public class Test {

	public static void main(String[] args) {
		
		Question52 test1 = new Question52();
		test1.boyut1 =  10;
		
		Question52 test2 = new Question52();
		test2.boyut1 = 15;
		boolean kontrol = test2.boyut1 == test1.boyut1;
		System.out.println(kontrol);
		test2.boyut1 = 10;
		kontrol = test2.boyut1 == test1.boyut1;
		System.out.println(kontrol);
		
		test1.dizi = test1.diziUret();
		kontrol = test1.dizi.length == test2.dizi.length; // true. Çünkü 'dizi' statik'tir (Question52 sınıfında).
		System.out.println(kontrol);
		
		Question52 test3 = new Question52();
		for(int i=0; i<test3.dizi.length; i++) {
			System.out.println(test3.dizi[i]);
		}

	}//main ends here

}//class ends here
