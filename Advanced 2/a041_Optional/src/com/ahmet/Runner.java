package com.ahmet;

import java.util.Optional;

public class Runner {
	static int sayi = 5;
	static Ogrenci ogr = new Ogrenci();
	static Ogrenci ogr2;
	public static void main(String[] args) {
/*
 * Primitive Data Type -> int, char, float, double, boolean
 *   default değer sahiptirler.
 * References Data Typ -> sınıf tiplerdir ve değişkenleri tanım
 * landığında değer olarak 'null' alır, atama yapıldığında(new ile)
 * oluşan nesnenin adresi atanır.
 * References Data typ'lar, null değer dönebileceğinden, yani
 * adreslerinin işaret ettiği bir değer olmadığından, sınıfların
 * içindeki değerlere erişim olmayacak ve NullPointerException
 * istisnası fırlatacaktır.
 */
		System.out.println("sayi.......: " + sayi);
		System.out.println("1'nci öğrencinin adı......:" + ogr.getAd());
//		System.out.println("2'nci öğrencinin adı......:" + ogr2.getAd()); // NullPointerException. - no such object as 'ogr2'
/*
 * *** OPTIONAL ***
 * Bir öğrenci olduğunuzu düşünün, dönem sonunda size bir dersten
 * kaç puan aldığınınz sorulduğunda cevap verirsiniz: 100 + 90 =
 * 95 ortalama ile geçtim denilebilir.
 * Ancak, bu soru ile dönem başında muhatap olduğunuzda şöyle 
 * bir cevap vermeniz mantıksız olacaktır: "Ders notum 0'dır".
 * Aslında daha hiç sınava girmemişsiniz, notunuzun 0 olma
 * ihtimali yoktur. İşte burada 'optional' tam olarak bu işi 
 * yapar. Yani "daha sınavlar başlamadı, ders notum yok"
 * diyebilmenizi sağlar.
 */
		
		System.out.println("Ortalaman Kaç.....: " + ortalama(100,60,80));
//		System.out.println("Ortalaman Kaç.....: " + ortalama());  // parametresiz
		Optional<Double> ort = ortalama(100, 60, 80);
		if(ort.isPresent()) {
			System.out.println(ort.get());
		}else {
			System.out.println("Sınavlara girmedim daha.");
		}
		ort.ifPresent(System.out::println);
		ort.ifPresent(p->{
			System.out.println("Ortalama(3)....: " + p);
		});
		ort.ifPresentOrElse(p->{
			System.out.println("Ortalama(4)....: " + p);
		}, ()->{
			System.out.println("Ortalama yok.");
		});
		//WITH TERNARY OPERATOR:
		Optional optionalOgr = ogr2==null ? Optional.empty() : Optional.of(ogr2);
		//Aşağıdaki satır, yukarıdakine göre daha kısa ve öz bir yazım şekli, ve aynı işi yapıyor:
		optionalOgr = Optional.ofNullable(ogr2);
		
		Optional<Double> ort2 = ortalama();
		/*
		 * Bir değeri okumak ya da erişmek istiyorsunuz. Ancak değer
		 * yok. Böyle durumlarda default bir değer kullanmak gerekebilir.
		 * Bunun için orElse kullanılır.
		 */
		System.out.println(ort2.orElse(Double.NaN));
		System.out.println(ort2.orElse(50d));
		
		Optional<String> isim = Optional.empty();
		System.out.println(isim.orElse("GİRİLMEMİŞ"));
		isim = Optional.of("Ahmet");
		System.out.println(isim.orElse("GİRİLMEMİŞ"));
	}//MAIN ENDS HERE --------
	
	private static Optional<Double> ortalama(double... notlar) {
		if(notlar.length == 0) { // Eğer öğrencinin notu yoksa
			return Optional.empty(); // (return value comes from 'Optional' class)
		}
		double ort = 0;
		for(double not: notlar) {
			ort += not;
		}		
		ort = ort / notlar.length;
		return Optional.of(ort);  // Önemli. (here, return value comes from 'Optional' class)
	}

}//CLASS ENDS HERE ------
