package pckge;

import java.time.LocalDate;
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
 * --------------------------
 * İSTİSNALAR:
 * throw -> istisna fırlatmak için kullanıyoruz; kendi koşullarımıza
 * uygulamak özelleştirmek için.
 * 
 * Checked Exception: Bir istisna fırlatmasını zorunlu hale getiriyoruz.
 * Unchecked Exception: Bir zorunluluk yok. 
 * 
 * Kendi İstisnamız: 'extends RunTimeException' yazıyoruz.
 * ---------
 * 
 * 1- throw fırlatalım - topla2 metodu yazalım (bu metodun 
 * içinde throw fırlatalım). Sonra null'ı
 * kontrol eden ve null pointer exception fırlatan bir metot
 * yazalım. Sonra bu kontrol metodunu toplam2'nin içinde 
 * kullanalım.
 */
public class TryCatchOrnek2 {
	
	static int numberOfExceptions = 0;
	
	public static void main(String[] args) {
		
		String[] array = { "a", "10", "bc", null, "20" };
//		Utility.intDegerAlma("Lütfen bir sayı giriniz: ");
		
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
		
		
//		int toplam = topla2(array);
		int toplam = topla4(array);
		
		System.out.println("Number of exceptions: " + numberOfExceptions);
		System.out.println("Toplam: " + toplam);
		System.out.println("----------------------------------------");
		
		LocalDate localDate = Utility.localDateeCevir();
		System.out.println(localDate);
		
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
	
	public static int topla2(String[] arr) {
		int toplam = 0;
		for(int i=0; i<arr.length; i++) {
			try {
				String deger2 = nullCheck(arr[i]); // nullCheck'ten gelen değer bir exception ise try'ı burada sonlandırır ve catch'e geçer.
				toplam += Integer.parseInt(deger2);
			}catch(Exception e) {
				System.out.println("Hata yakalandı: " + e.toString());
				numberOfExceptions++;
			}finally {
				System.out.println("Şu anki eleman: " + arr[i]);
				System.out.println("-----");
			}
		}
		return toplam;
	}
	
	public static int topla3(String[] arr) {
		int toplam = 0;
		for(int i=0; i<arr.length; i++) {
			try {
				nullCheck2(arr[i]);
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		return toplam;
	}
	
	public static int topla4(String[] arr) { // Kendi exception sınıfımızı yakaladığımız metot.
		int toplam = 0;
		for(int i=0; i<arr.length; i++) {
			try {
				String deger2 = nullCheck4(arr[i]); 
				toplam += Integer.parseInt(deger2);
			}catch(Exception e) {
				System.out.println("Hata yakalandı: " + e.toString());				
				numberOfExceptions++;
			}finally {
				System.out.println("Şu anki eleman: " + arr[i]);
				System.out.println("-----");
			}
		}
		return toplam;
	}
	
	public static String nullCheck(String deger) {
		if(deger == null) {
			throw new NullPointerException("Null değer olamaz!"); // bu satır çalıştığı zaman throw 'return' gibi metodu sonlandırır; fırlattığı exception'ı metodun execute edildiği yere iletir.
		}
		return deger;		
	}
	
	public static String nullCheck2(String deger) throws Exception { // checked exception ('throws Exception'). When this method is executed, it has to be executed in a try-catch block.
		if(deger == null) {
			throw new NullPointerException("Null değer olamaz!"); // bu satır çalıştığı zaman throw 'return' gibi metodu sonlandırır; fırlattığı exception'ı metodun execute edildiği yere iletir.
		}
		return deger;		
	}
	
	public static String nullCheck4(String deger) throws Exception { 
		if(deger == null) {
			throw new NullKontrolException("Kendi exception'ımız; Null değer olamaz!"); // kendi yarattığımız 'NullKontrolException' sınıfı.
		}
		return deger;		
	}
	
	
	
}//CLASS ENDS HERE ------
