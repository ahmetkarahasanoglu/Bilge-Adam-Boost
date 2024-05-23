package com.ahmet;

import java.util.Scanner;

import com.ahmet.entity.De;
import com.ahmet.entity.En;
import com.ahmet.entity.IDil;
import com.ahmet.entity.Tr;

public class Runner {
	
	private static IDil dil; // Bilgi: Interface'lerde new'leme olmaz. Zaten Interface belgesinde metotların gövdeleri yoktur; oluşturulacak bir şey yoktur. Sadece bir sözleşmedir Interface.
	

	public static void main(String[] args) {
		/*
		 * Programa dil özelliği ekleme
		 */
//		dil = new Tr();
//		dil = new En();  // sadece Tr'yi En yaparak dili değiştirmiş olduk.
//		dil = new De();
		
		int secim = dilSecimi();
		switch(secim) {
			case 1:
				dil = new Tr();
				break;
			case 2:
				dil = new En();
				break;
			case 3:
				dil = new De();
				break;
			case 4:
				
				break;
			default:
				dil = new En();  // default dilimiz İngilizce.
		}
		
		System.out.println("***************************");
		System.out.println("*** "+dil.getHello()+" ****");
		System.out.println("***************************");
		System.out.println();
		System.out.println("1- "+dil.getLogin1());
		System.out.println("2- "+dil.getLogin2());
		System.out.println("3- "+dil.getLogin3());
		System.out.println("4- "+dil.getLogin4());
		System.out.println();
		System.out.println(dil.getStop());
		
		
	}//main ends here

	private static int dilSecimi() {
		System.out.println("1. Türkçe");
		System.out.println("2. İngilizce");
		System.out.println("3. Almanca");
		System.out.println("4. Fransızca");
		System.out.println("Lütfen Dil Seçiniz......:");
		Scanner sc = new Scanner(System.in);
		int secim = sc.nextInt();
		return secim;
	}
	
}//class ends here
