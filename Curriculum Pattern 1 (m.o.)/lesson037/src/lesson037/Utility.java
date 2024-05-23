package lesson037;

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
		System.out.println(sorgu);
		return Integer.parseInt(scanner.nextLine());
	}

	public static int randomSayıUret(int baslangic, int bitis) {
		Random random = new Random();
		return random.nextInt(baslangic, bitis);
	}
	
	public static LocalDate localDateeCevir(String strDate) {
		do {
			
		}while()
	}

}
