package com.ahmet;

import com.ahmet.entity.Urun;

public class Runner {

	public static void main(String[] args) {
		
		Urun urun1 = new Urun();
		System.out.println("Ürün 1 id....: " + urun1.id);
		System.out.println("Ürün 1 uuid..: " + urun1.uuid);
		System.out.println("Ürün 1 ad....: " + urun1.ad);
		System.out.println("Ürün 1 marka.: " + urun1.marka);
		
		Urun urun2 = new Urun();
		System.out.println("Ürün 2 id....: " + urun2.id);
		System.out.println("Ürün 2 uuid..: " + urun2.uuid);
		System.out.println("Ürün 2 ad....: " + urun2.ad);
		System.out.println("Ürün 2 marka.: " + urun2.marka);
		
		System.out.println("Ürün 1 id....: " + urun1.id);
		System.out.println("Ürün 1 uuid..: " + urun1.uuid);

	}//main ends here

}//class ends here
