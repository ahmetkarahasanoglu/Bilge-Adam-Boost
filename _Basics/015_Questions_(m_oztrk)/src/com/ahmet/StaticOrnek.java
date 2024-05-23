package com.ahmet;

public class StaticOrnek {
	
	int number = 0;
	static int number2 = 0;

	public static void main(String[] args) {
		
//		StaticOrnek staticOrnek = new StaticOrnek();
//		staticOrnek.number = 2;		
//		staticOrnek.numaraVer();
//		staticOrnek = new StaticOrnek(); // !!! new'lemek, static olan number2'yi sıfırlamaz! number'ı sıfırlar sadece.
//		staticOrnek.numaraVer();	
//		number = 40; // "Cannot make a static reference to the non-static field 'number'.
//		number2 = 50;
		System.out.println(number2);
		
	}//main ends here
	
	public void numaraVer() {
		number += 1;
		number2 += 1;		
		System.out.println("number: " + number);
		System.out.println("number2 :" + number2);
	}

}//class ends here
