package com.ahmet;

public class Student {	
/* Soru: Öğrencilerin isimleri ve numaraları olsun.
 * Öğrenci numaraları 1'den başlasın, yeni öğrenci kaydı 
 * oldukça numaralar artsın.
 */
	
	// --- MY CODE: ---
//	String isim;
//	int numara;
//	static int nextNumara = 1;
//	
//	public static Student yeniOgrenciOlustur(String isim) {
//		Student student = new Student();
//		student.isim = isim;		
//		student.numara = nextNumara;
//		nextNumara++;
//		return student;
//	}
	
	// ---TEACHER'S CODE:---
	String ad;
	static int numara;
	
	public void kayit() {
		numara += 1;
		System.out.println(ad + " adlı öğrenci " + numara + " nosu ile kayıt olmuştur.");
	}
	
	
	
}
