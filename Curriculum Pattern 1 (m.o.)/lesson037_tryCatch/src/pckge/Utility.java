package pckge;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
/*
 * String olarak aldığımız tarihi localdate olarak bize dönen
 * bir metot yazalım. Doğru değer girene kadar tarih değeri
 * alalım.
 */
public class Utility {

	static Scanner scanner = new Scanner(System.in);	

	public static String stringDegerAlma(String sorgu) {
		System.out.println(sorgu);
		return scanner.nextLine();
	}

	public static int intDegerAlma(String sorgu) {
		boolean isException = false;
		Integer deger = null;
		do {
			try {
				System.out.println(sorgu);
				deger = Integer.parseInt(scanner.nextLine());
				isException = false;
			}catch(Exception e) {
				System.out.println("Geçersiz giriş! Lütfen bir rakam değeri giriniz!");
				isException = true;
			}
		}while(isException);
		return deger;
	}

	public static int randomSayıUret(int baslangic, int bitis) {
		Random random = new Random();
		return random.nextInt(baslangic, bitis);
	}
	
	public static LocalDate localDateeCevir() {		
		LocalDate localDate = null;
		boolean isException = false;
		do {
			try {
				System.out.print("Tarih giriniz (yyyy-mm-dd): ");
				String strDate = scanner.nextLine();				
				localDate = LocalDate.parse(strDate);
				isException = false;
			}catch(Exception e) {
				System.out.println("Hata oluştu. Lütfen örnekteki gibi giriniz: 2020-01-25 . " + e);
				isException = true;
			}
		}while(isException);
		return localDate;
	}

}
