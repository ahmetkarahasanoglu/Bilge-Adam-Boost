package com.package1;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {
		
		// Soru: Dairenin alanını ve çevresini bulalım. Yarıçapı 
		// kullanıcıdan alacağız.
		// pi = 3.14
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the radius of the circle: ");
		float radius = scanner.nextFloat();
		float areaOfCircle = 3.14f * radius * radius;
		float circumference = 2 * 3.14f * radius;
		
		System.out.println("Area of the circle: " + areaOfCircle);
		System.out.println("Circumference: " + circumference);
		
		scanner.close();
	}

}
