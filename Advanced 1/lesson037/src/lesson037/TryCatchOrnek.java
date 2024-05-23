package lesson037;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * Bir bölme metodum olsun, dışardan iki parametre alsın,
 * bölme işlemini yapıp sonucunu dönsün. * 
 * main'de for döngüsü kuracağız. 3 kere çalışsın. Bu for
 * döngüsü içinde de try-catch yapısını kullanalım.
 */
public class TryCatchOrnek {
	
	static List<String> list;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		try {
//			list.add("1");
//		}catch (Exception e) {
//			System.out.println(e.toString());
//			System.out.println("--------------------");
//			System.out.println(e.getMessage());
//			System.out.println("--------------------");
//			e.printStackTrace();
//			System.out.println("--------------------");
//		}
//		
//		System.out.println("Uygulamam devam ediyor.");
		
		TryCatchOrnek tryCatchOrnek = new TryCatchOrnek();
		
//		for(int i=0; i<3; i++) {
//			try {
//				int bolum = tryCatchOrnek.bolmeIslemi();
//				System.out.println("Bölme sonucu: " + bolum);
//			}catch(ArithmeticException e) {
//				System.out.println("Hata yakalandı. Bölen 0 olamaz. " + e.toString());
//			}catch(InputMismatchException e) {
//				System.out.println("Hata yakalandı. Geçersiz giriş; sadece sayı giriniz. " + e.toString());
//			}catch(Exception e) {
//				System.out.println("Hata yakalandı: " + e.toString());
//			}
//		}
		
		boolean isException = false;
		do {
			try {
				int bolum = tryCatchOrnek.bolmeIslemi();
				System.out.println("Bölme sonucu: " + bolum);
				isException = false;
			}catch(ArithmeticException e) {
				System.out.println("Hata yakalandı. Bölen 0 olamaz. " + e.toString());
				isException = true;
			}catch(InputMismatchException e) {
				System.out.println("Hata yakalandı. Geçersiz giriş; sadece sayı giriniz. " + e.toString());
				isException = true;
			}catch(Exception e) {
				System.out.println("Hata yakalandı. Beklenmedik bir hata. " + e.toString());
				isException = true;
			}
		}while(isException);
	
	}//MAIN ENDS HERE -------
	
	public  int bolmeIslemi() {
		System.out.print("Bölüneni giriniz: ");
		int bolunen = Integer.parseInt(sc.nextLine());
		System.out.print("Böleni giriniz: ");
		int bolen = Integer.parseInt(sc.nextLine());
		return bolunen / bolen;
	}
	
}//CLASS ENDS HERE -----
