package com.ahmet;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {
/*
 *    Kullanıcılardan almış olduğumuz datalar, bir şekilde kayıt
 * altına alınmalı ve gerekli olduğu zaman tekrar çağrılarak
 * kullanılmalıdır. 
 *    Dataların kalıcı olarak kayıt edildiği uygulamalara DataBase
 * adı verilir. Bu uygulamalar ile datalar uzun süreli saklanır
 * ve yedeklenirler.
 *    Dataların ihtiyaca göre işlenmeye ihtiyacı vardır. Bu
 * nedenle gerekli olduğunda farklı sorgularla çağrılmalıdırlar.
 * Örneğin:
 *    - bir kişiye ait sepet bilgisini görmek isiyoruz.
 *    - bir kullanıcıının son 3 ayda yaptığı alışverişlerin
 * toplam tutarının tüm müşteriler içindeki oranını görmek
 * istiyoruz.
 *   Bu işlemlerin Database üzerinden yapılması, çok fazla istek
 * atmaya ve sistemi yavaşlatmaya neden olabilir.
 *   ** Veritabanından gerekli olan bilgiler tek seferde alınarak,
 * Listelerin içerisine konulur.
 * Dikkat: Ben daha çok listeler ile çalışmalıyım ki daha 
 * performanslı kodlar yazabileyim. Ancak burada dikkat edilmesi
 * gereken durum, listeleri mükemmel bir şekilde kullanabiliyor
 * olmam gerekli.
 *     Stream Api, bizim ihtiyacımız olan listelerin aranması, 
 * yönetilmesi için gerekli özelleştirilmiş bir sınıftır. * 
 */
		// count = 0;
		Stream<String> bosStream = Stream.empty();
		// count = 1;
		Stream<String> tekilStream = Stream.of("Pazartesi");
		// count = 4;
		Stream<Double> sayilar = Stream.of(22d, 1d, 11d, 2.5d);
		List<String> gunler = List.of("pzt.", "sa.", "çar.", "per.", "cu.", "ctes.", "paz.");
		
		/*
		 * Tüm listelerde stream miras olarak alınmaktadır. Bu
		 * nedenler tüm listeler stream'e döndürülebilir.
		 * örn: gunler.stream()
		 */
		
		/*
		 * List -> Stream 'e çevirelim ve içindeki parametreleri
		 * dönelim:
		 */
		Stream<String> gunlerStream = gunler.stream();  // List'i Stream'e çevirdik.
//		gunlerStream.forEach(System.out::println);
//		gunlerStream.forEach(g->System.out.println(g)); // Tek satır kod çalıştırabiliyoruz burda.
		gunlerStream.forEach(g->{
			System.out.println("Önce yapılacaklar");
			System.out.println(g);
			System.out.println("ek işlemleri");
		});
		
		// --- SONSUZ STREAM'LER: ---
		Stream<Double> rastgeleRandomSayilar = Stream.generate(Math::random);
//		rastgeleRandomSayilar.forEach(System.out::println);
		
		Stream<Integer> fonksiyonSayilar = Stream.iterate(1, n -> n+2); // 1 3 5 7 ... infinitely
//		fonksiyonSayilar.forEach(System.out::println);
		
		fonksiyonSayilar = Stream.iterate(1, n -> n<20, n -> n+2);
		fonksiyonSayilar.forEach(p -> System.out.println(p));
		
		/*
		 * --- METOTLAR (stream'in metotları) ---
		 * count -> eleman sayısı
		 * min, max -> en küçün ve büyük değer
		 * forEach -> bileşenlerini dönmek için.
		 */
		
		
		System.out.println("sayilar count.....: " + sayilar.count());
//		System.out.println("Rastgele sonsuz sayı count...: " + rastgeleRandomSayilar.count());  // çıktıda bir şey göstermez. Sürekli hesaplama yapar, sonsuz döngü.
		
		Stream<String> isimler = Stream.of("Ahmet", "Can", "Kemalettin", "Buse");
		// Farklar........................:		   2	  7				6
		//bir string ifade dizisinde isim uzunluğu en küçük olanı versin:
		Optional<String> minIsim = isimler.min((s1,s2) -> s1.length() - s2.length());
		minIsim.ifPresent(System.out::println); // Output: Can  ( 'ifPresent' -> Eğer bir minimum değer mevcut ise demektir.)
		
		/*
		 *  
		 */
		String[] harfler = new String[] {"M", "u", "h", "a", "m", "m", "e", "t"};
		//harflari birleştirip bir kelime yapmak istiyoruz. for( : ) ile yapmamız mümkün:
		String isim = "";
		for(String harf: harfler) {
			isim += harf;			
		}
		System.out.println("İsim.........: " + isim);
		
		Stream<String> streamHarfler = Stream.of("M", "u", "h", "a", "m", "m", "e", "t");
		String streamIsim = streamHarfler.reduce("", (ad,harf)->ad+harf);
		System.out.println("Reduce ile...: " + streamIsim);
		
		Stream<Integer> streamSayilar = Stream.of(3,5,7);
		Optional<Integer> toplam = streamSayilar.reduce((total, accumulator)-> total + accumulator);
		System.out.println("Toplam (reduce ile): " + toplam.get());
		
		Stream<Integer> streamInt = Stream.of(3,5,6);
		Integer sonuc = streamInt.reduce(1,(total, accumulator) -> total * accumulator); // Here, '1' is the beginning value of 'total'.
		System.out.println("Çarpım (reduce ile): " + sonuc);
	
		// BINARY OPERATOR
		BinaryOperator<Integer> op = (a,b) -> a*b;
		Stream<Integer> streamInt2 = Stream.of(3,5,8,2);
		streamInt2.reduce(op).ifPresent(System.out::println);
		Stream<Integer> bosDizi = Stream.empty();
		bosDizi.reduce(op).ifPresentOrElse(p->{
			System.out.println("sonuç: " + p);
		}, () ->{
			System.out.println("Herhangi bir sonuç üretilmedi");
		});
	
	}//MAIN ENDS HERE --------

}//CLASS ENDS HERE -------
