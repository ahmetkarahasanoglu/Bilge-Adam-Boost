package lesson037;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1- Bir metot ile dışardan bir indeks değeri alalım. Sonra o
 * indeks'deki değeri yazdıralım. Hata varsa try-catch ile
 * yakalayalım.
 * 
 * 2- Array üzerinde gezelim. Sayısal değerleri integer'a 
 * çevirip bir toplama işlemi yapacağız. Yani bir toplama
 * metodu yazacağız. En sonunda toplamı ve hata sayısını
 * yazdıralım.
 */
public class TryCatchOrnek2 {
	
	static int numberOfExceptions = 0;
	
	public static void main(String[] args) {
		
		String[] array = { "a", "10", "bc", null, "20" };
		
//		try {
//			int index = indexAl();
//			System.out.println(array[index]);
//		}catch(IndexOutOfBoundsException e) {
//			System.out.println("Lütfen index dizinin boyutları içinde bir index giriniz. " + e);			
//		}catch(InputMismatchException e) {
//			System.out.println("Geçersiz giriş; lütfen rakam giriniz. " + e);
//		}catch(Exception e) {
//			System.out.println("Beklenmedik hata. " + e );
//		}
		
		
		int toplam = topla(array);
		
		System.out.println("Number of exceptions: " + numberOfExceptions);
		System.out.println("Toplam: " + toplam);
		
	}//MAIN ENDS HERE ------
	
	public static int indexAl() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Lütfen bir index giriniz: ");
		int index = sc.nextInt();
		return index;
	}
	
	public static int topla(String[] arr) {
		int toplam = 0;
		for(int i=0; i<arr.length; i++) {
			try {
				toplam += Integer.parseInt(arr[i]);
			}catch(Exception e) {
				System.out.println("Hata yakalandı: " + e);
				numberOfExceptions++;
			}finally {
				System.out.println("Şu anki eleman: " + arr[i]);
				System.out.println("-----");
			}
		}
		return toplam;
	}
	
}//CLASS ENDS HERE ------
