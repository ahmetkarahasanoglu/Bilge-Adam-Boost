package pckge;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Bir metot ile dışarıdan bir index degeri alalım sonra o indexedeki değeri yazdıralım 
 * hata varsada try catch ile yakalayalım
 * 
 * 2- Array uzerinde gezelim sayısal degerleri integerecevirip bir toplama işlemi yapacagız 
 * yani bir toplama metodu yazacagız en sonunda toplamı ve hata sayısını yazdıralım 
 * 
 */
public class TryCatchOrnek2_Tchrs {
	/*
	 * throw // istisna fırlatmak için kullanıyoruz // kendi kosullarımıza uygulamak
	 * özelleştirmek için checked-- // bir ıstısna fırlatmasını zorunlu hale
	 * getiriyoruz unckhecked--// bir zorunluluk yok extends RunTimeException
	 * 
	 * 1- throw fırlatalım - toplam2 metodu yazalım sonra birtanede nullu kontrol
	 * eden ve null pointerexception fırlatan bir metot yazalım sonra bu kontrol
	 * metodunu toplam2 nin içinde kullanalım
	 */
	public static void main(String[] args) {
		String[] array = { "a", "10", "bc", null, "20" };

		// indexAl(array);
		// toplam(array);
		// Utility.stringTarihAlma();
		// Utility.intDegerAlma("Lütfen bir sayi giriniz");
		toplam4(array);
	}

	public static void indexAl(String[] array) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen bir index degeri giriniz");
		try {
			int index = scanner.nextInt();
			String deger = array[index];
			System.out.println("girdiginiz indexdeki deger: " + deger);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Girdiğiniz index dizinin boyutları dısındadır lütfen 0 ile" + (array.length - 1)
					+ "arasında bir deger giriniz");
			System.out.println(e.toString());
		} catch (InputMismatchException e) {
			System.out.println("Lütfen index degerini bir rakam olarak giriniz");
			System.out.println(e.toString());
		}

	}

	public static void toplam(String[] array) {

		int toplam = 0;
		int sayac = 0;

		for (String string : array) {

			try {
				int deger = Integer.parseInt(string);
				toplam += deger;
			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				sayac++;
			} finally {
				System.out.println("finally:" + string);
			}

		}
		System.out.println("toplam= " + toplam);
		System.out.println("hata sayısı= " + sayac);

	}

//uncheked exception fırlattık
	public static String nullCheck(String deger) {

		if (deger == null) {

			throw new NullPointerException("Null deger olamaz!");
		}

		return deger;

	}

	// checked exception fırlattık
	public static String nullCheck2(String deger) throws Exception {

		if (deger == null) {

			throw new Exception("Null deger olamaz!");
		}

		return deger;

	}

	// unchecked exception fırlattık
	public static String nullCheck3(String deger) throws NullPointerException {

		if (deger == null) {

			throw new NullPointerException("Null deger olamaz!");
		}

		return deger;

	}

	// kendi exception sınfımızı fırlattık
	public static String nullCheck4(String deger)  {
		if (deger == null) {
			throw new NullKontrolException("Nul deger olmasın!!!!!!");
		}
		return deger;
	}

	// throw ile fırlattıgımız exception'ı yakaladık
	public static void toplam2(String[] array) {

		int toplam = 0;
		int sayac = 0;
		String deger2 = "bos";
		for (String string : array) {

			try {
				deger2 = "bos";
				deger2 = nullCheck(string);
				int deger = Integer.parseInt(deger2);
				toplam += deger;
			} catch (Exception e) {
				System.out.println(e.toString());
				sayac++;
			} finally {
				System.out.println("finally:" + deger2);
			}

		}
		System.out.println("toplam= " + toplam);
		System.out.println("hata sayısı= " + sayac);

	}

//Checked exception yakaldık
	public static void toplam3(String[] array) {

		int toplam = 0;
		int sayac = 0;
		String deger2 = "bos";
		for (String string : array) {

			try {
				deger2 = "bos";
				deger2 = nullCheck2(string);
				int deger = Integer.parseInt(deger2);
				toplam += deger;
			} catch (Exception e) {
				System.out.println(e.toString());
				sayac++;
			} finally {
				System.out.println("finally:" + deger2);
			}

		}
		System.out.println("toplam= " + toplam);
		System.out.println("hata sayısı= " + sayac);

	}

	// Kendi eXception sınıfımızı yakaladağımız metot
	public static void toplam4(String[] array) {

		int toplam = 0;
		int sayac = 0;
		String deger2 = "bos";
		for (String string : array) {

			try {
				deger2 = "bos";
				deger2 = nullCheck4(string);
				int deger = Integer.parseInt(deger2);
				toplam += deger;
			} catch (NullKontrolException e) {
				System.out.println(e.toString());
				System.out.println(e.getMesaj());

				sayac++;
			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				sayac++;
			}

			finally {
				System.out.println("finally:" + deger2);
			}

		}
		System.out.println("toplam= " + toplam);
		System.out.println("hata sayısı= " + sayac);

	}
}
