package com.ahmet;

public class Methods2_MethodTypes {
	/*
	 * Bir sınıf içinde şunlar tanımlanabilir;
	 * 1) değişken 
	 * 2) method 
	 * 3) inner class, wrapper class 
	 * 4) enum
	 */

	public static void main(String[] args) {
		/* to run the method, we must call it in main method.
		 * bir method içinde başka bir method çağrılabilir.
		 * DİKKAT !!!: bir static method sadece statik bileşenlerle çalışır (istisnalar ve farklı kullanımlar hariç)
		 * 
		 */
		
		myMethod(); // myMethod must be described as static; because the main method here is static.
		topla(3,5);
		hangisiBuyukVeyaKucuk(10,20, "kucuk");

	}//end of main
	public static void myMethod() {
		
	}
	public static void topla(int sayi1, int sayi2) {
		int toplam = sayi1 + sayi2;
		System.out.println("İki sayının toplamı: " + toplam);
	}
	public static void hangisiBuyukVeyaKucuk(int sayi1, int sayi2, String buyukKucuk) {
		if(buyukKucuk.equals("buyuk")) {
			if(sayi1>sayi2) {
				System.out.println("Büyük sayı: " + sayi1);
			}else if(sayi2>sayi1) {
				System.out.println("Büyük sayı: " + sayi2);
			}else {
				System.out.println("Girdiğiniz sayılar eşit.");
			}
		}else if(buyukKucuk.equals("kucuk")) {
			if(sayi1<sayi2) {
				System.out.println("Küçük sayı: " + sayi1);
			}else if(sayi2<sayi1) {
				System.out.println("Küçük sayı: " + sayi2);
			}else {
				System.out.println("Girdiğiniz sayılar eşit.");
			}
		}
	}
	
}//end of class
