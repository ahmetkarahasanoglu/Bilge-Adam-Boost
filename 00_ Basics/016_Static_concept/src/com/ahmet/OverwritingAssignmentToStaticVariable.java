package com.ahmet;

public class OverwritingAssignmentToStaticVariable {

	public static void main(String[] args) {
		Musteri musteri1 = new Musteri();
		Musteri musteri2 = new Musteri();
		Musteri musteri3 = new Musteri();
		musteri1.ad = "Ahmet";
		musteri2.ad = "Hasan";
		musteri3.ad = "Selami";
		System.out.println("Müşteri 1 ad..........: " + musteri1.ad); // Ahmet
		System.out.println("Müşteri 2 ad..........: " + musteri2.ad); // Hasan
		System.out.println("Müşteri 3 ad..........: " + musteri3.ad); // Selami
		
		
		musteri1.postCode = "35000";
		System.out.println("Müşteri 1 posta kodu..: " + musteri1.postCode); // 35000
		System.out.println("Müşteri 2 posta kodu..: " + musteri2.postCode); // 35000
		System.out.println("Müşteri sınıfndan eriş: " + Musteri.postCode);  // 35000
		musteri2.postCode = "16000";
		System.out.println("Müşteri 2 posta kodu..: " + musteri2.postCode); // 16000
		musteri3.postCode = "07000";
		System.out.println("Müşteri 1 posta kodu..: " + musteri1.postCode); // 07000
		System.out.println("Müşteri 2 posta kodu..: " + musteri2.postCode); // 07000
		System.out.println("Müşteri 3 posta kodu..: " + musteri3.postCode); // 07000 
		// '--> The memory place for postCode for all objects from 'Musteri' class is same. Because it's a static variable.
		
		

	}

}
