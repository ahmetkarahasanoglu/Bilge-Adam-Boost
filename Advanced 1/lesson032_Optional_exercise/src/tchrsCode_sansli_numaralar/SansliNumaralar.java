package tchrsCode_sansli_numaralar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
/*
 * 1 den 100 e kadar rastgele
 * 10 000 tane sayı ureteceğiz. 
 * 1- sayıolustur metodu ile rastgele olusturduğumuz sayıları map a atacağız 
 * sayının kaç kere olduğunu tutacağız key değeri sayı 
 * value değeri ise kaç kere üretildiği.
 * 
 * 2-map de gezinirken  listeye ekleyeceğiz her elaman
 *  ne kadar tekrar ediyorsa o kadar
 * kez listeye ekleyeceğiz
 * 
 *3- en son listeden rastgele 10 adet değer alacğız ve bunu bir set e ekleyeceğiz 
 *önce listeyi karıstıralm Collections.suhffle();
 *ben bir set olusturacagım bu setin içine 10 tane rakam ekleyecegim 
 *
 */
public class SansliNumaralar {
	
	static final int maxSayi = 100;
	static final int uretilenSayiMiktari = 10_000;
	
	Map<Integer, Integer> sayilarMap = new HashMap<>();
	List<Integer> sayilarListesi = new ArrayList<>();	
	Set<Integer> sansliNumaralar = new TreeSet<>();
	
	public void mapOlustur() {
		for(int i=0; i<uretilenSayiMiktari; i++) {
			Random random = new Random();
			int sayi = random.nextInt(1, 101);
			if(sayilarMap.containsKey(sayi)) {
				sayilarMap.put(sayi, sayilarMap.get(sayi) + 1);				
			}else {
				sayilarMap.put(sayi, 1);
			}
		}
	}
	
	public void mapYazdir() {
		sayilarMap.forEach((k,v)->System.out.println(k + " sayisi " + v + " adet bulunmaktadır."));
	}
	
	public void listeOlustur() {
		sayilarMap.forEach((k,v)->{
			for(int i=0; i<v; i++) {
				sayilarListesi.add(k);
			}
		});
		//Another Way:
//		for(Map.Entry<Integer, Integer> sayi : sayilarMap.entrySet()) {
//			for(int i=0; i<sayi.getValue(); i++) {
//				sayilarListesi.add(sayi.getKey());
//			}			
//		}
	}
	
	public void listeYazdir() {
		sayilarListesi.forEach(x -> System.out.println(x));
	}
	
	public void sansliNumaralariBelirle() {		
		Collections.shuffle(sayilarListesi);
		while(sansliNumaralar.size() < 10) {
			Random random = new Random();
			int randIdx = random.nextInt(0, 10_000);
			sansliNumaralar.add(sayilarListesi.get(randIdx));
			sayilarListesi.remove(randIdx); // we're removing the number that we've just picked.
		}
	}
	
	public void yazdirSansliNumaralar() {
		System.out.println("--- Şanslı 10 sayı: ---");
		sansliNumaralar.forEach(x -> System.out.println(x));
		
	}
	// 'collect' kullanımı, 'filter' kullanımı:
	public void yazdir50denBuyukSayilarSansliNumaralardan() {
		sansliNumaralar.stream().filter(x -> x>50).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
		// * Another Way:
//		Set<Integer> mySet = new TreeSet(); // pay att: 'TreeSet()'
//		mySet.addAll(sansliNumaralar.stream().filter(x -> x>50).collect(Collectors.toSet()));		
//		mySet.forEach(System.out::println);		
	}
	
	public void yazdirTotalOf50denBuyukSayilarSansliNumaralardan() {
		Optional<Integer> toplam = sansliNumaralar.stream().filter(x -> x>50).reduce((total, accumulator) -> total + accumulator);
		toplam.ifPresent(System.out::println);
		// * Or, we can do it on a sinle line like this (we added  ifPresent(System.out::println)  at the end).
//		sansliNumaralar.stream().filter(x -> x>50).reduce((total, accumulator) -> total + accumulator).ifPresent(System.out::println);
		
		// * .get() method of an Optional<T> variable: (IMPORTANT !!!!!!!!)
		Integer toplam2 = toplam.get(); // get() method: If a value is present, returns the value, otherwise throws NoSuchElementException.
//		System.out.println(toplam2);
		
//		Optional<String> kelime = Optional.empty();
//		System.out.println(kelime);
		
		Optional<String> kelime2 = Optional.ofNullable(null); // IMPORTANT: 'Optional.ofNullable(null)' doesn't throw NullPointerException, it just returns 'Optional.empty'. But 'Optional.of(....)' may throw a NullPointerException. 
		System.out.println(kelime2);
		
		Optional<String> kelime3 = Optional.of(null); // throws NullPointerException
		System.out.println(kelime3);
	}
}
