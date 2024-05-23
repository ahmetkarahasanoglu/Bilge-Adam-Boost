package com.ahmet;

import java.util.Scanner;

public class Runner {

	private static IDil dil;
	
	public static void main(String[] args) {
		
//		Runner runner = new Runner();
		int secim = secimYap();
		switch(secim) {
			case 1: dil = new Tr(); break;
			case 2: dil = new En(); break;
			case 3: dil = new De(); break;
			default:dil = new En(); break;
		}
		
		System.out.println("****************************");
		System.out.println("******"+dil.getHello()+"*****");
		System.out.println("****************************");
		System.out.println(dil.getSignUp());
		System.out.println(dil.getLogin());
		System.out.println(dil.getGuest());
		System.out.println(dil.getIntroduction());
		System.out.println(dil.getStop());
		
		
	}//main ends here
	
	private static int secimYap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Türkçe");
		System.out.println("2. İngilizce");
		System.out.println("3. Almanca");
		System.out.print("Seçim yapınız: ");
		int secim = sc.nextInt();
		sc.close();
		return secim;
	}
	
}//class ends here
