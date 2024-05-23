package com.ahmet;

import com.ahmet.entity.Kedi;

public class Runner {
	
	public static void main(String[] args) {
/*
 * CONSTRUCTOR:
 * 1) 'public' anahtar kelimesiyle kullanılır. Özel durumlarda
 * değiştirilebilir.
 * 2) return type yoktur. [geriye döndürdüğü şey o sınıfın küçük harfle yazılan nesnesidir].
 * 3) sınıfın adı neyse bu metodun adı da aynıdır.
 * 4) Metot parametre alabilir, ancak parametre alır ise default
 * constructor iptal olur.
 */
		Kedi kedi = new Kedi(); // aslında burada 'Kedi()' bir metottur (constructor'dır), ve return ettiği şey 'kedi' nesnesidir.
		String ifade = kedi.Pisicik();
//		String ifade2 = kedi.Selamla(); // kedi.Selamla()'nın geri dönüş değeri yok (hiçbir şeyi return etmiyor). O yüzden hata verir.
		
		System.out.println("kedi türü....: " + kedi.tur);
		System.out.println("kedi boyu....: " + kedi.boy);
		System.out.println("kedi kilo....: " + kedi.agirlik);
		
	}//main ends here
}//class ends here

