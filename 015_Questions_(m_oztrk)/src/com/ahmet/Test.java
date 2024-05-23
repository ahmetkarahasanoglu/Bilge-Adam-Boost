package com.ahmet;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
/*
 * Student class'ından öğrenci numarası oluşturup yazdıralım.		
 */

		
//		//--- MY CODE: ---
//		Student[] studentArr = new Student[5];
//		
//		Student ogrenci1 = Student.yeniOgrenciOlustur("Ahmet");
//		studentArr[0] = ogrenci1;
//		System.out.println(ogrenci1.isim);
//		System.out.println(ogrenci1.numara);
//		
//		Student ogrenci2 = Student.yeniOgrenciOlustur("Selami");
//		studentArr[1] = ogrenci2;
//		System.out.println(ogrenci2.isim);
//		System.out.println(ogrenci2.numara);
//		
//		System.out.println(ogrenci1.numara);
//		
//		for(int i=0; i<studentArr.length; i++) {
//			if(studentArr[i] != null) {
//				System.out.println(studentArr[i].isim + " isimli öğrencinin numarası: " + studentArr[i].numara);
//			}			
//		}
		
		
//		//---TEACHER'S CODE (VERSION 1):---
//		Student student1 = new Student();
//		student1.ad = "Mustafa";
//		student1.kayit();
//		Student student2 = new Student();
//		student2.ad = "Yasin";
//		student2.kayit();
//		student2 = new Student();
//		student2.ad = "Merve";
//		student2.kayit();
		
		
		// ---TEACHER'S CODE (VERSION 2):---
		Scanner scanner = new Scanner(System.in);
		String input = "e";
		do {
			Student student = new Student();
			System.out.print("Öğrenci ismi giriniz: ");
			student.ad = scanner.nextLine();
			student.kayit();
			
			System.out.println("Yeni bir kayıt daha yapacaksanız 'e' giriniz: ");
			input = scanner.nextLine();
		}while(input.equalsIgnoreCase("e")); 
		
		
	}//main ends here

}//class ends here
