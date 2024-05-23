package sansli_numaralar_myCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

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
	
	List<Integer> sayilar = new ArrayList<>();
	Map<Integer, Integer> map = new HashMap<>();
	Set<Integer> set10sayi = new TreeSet<>();
	
	
	public void sayiOlustur() {
		Random random = new Random();
		for(int i=0; i<10_000; i++) {
			int randNum = random.nextInt(1,101);
			sayilar.add(randNum);
		}
	}
	
	public void mapOlustur() {
		Set<Integer> mySet = new LinkedHashSet<>();		
		List<Integer> sayilarCopy = new ArrayList<>(sayilar);
		for(int i=0; i<sayilar.size(); i++) {
			mySet.add(sayilar.get(i));			
		}
		List<Integer> mySetAsList = List.copyOf(mySet);		
		for(int i=0; i<mySetAsList.size(); i++) {			
			int count = 0;			
			while(sayilarCopy.contains(mySetAsList.get(i))) {				
				int index = sayilarCopy.indexOf(mySetAsList.get(i));
				sayilarCopy.remove(index);
				count++;				
			}
			map.put(mySetAsList.get(i), count);			
		}		
	}
	
	public void mapYazdir() {
		map.forEach((k,v)->System.out.println(k + " sayisi " + v + " adet bulunmaktadır."));
	}
	
	public void rastgele10sayiCek() {		
		Collections.shuffle(sayilar);
		for(int i=0; i<10; i++) {
			Random random = new Random();
			int randIdx = random.nextInt(0, 10_000);
			set10sayi.add(sayilar.get(randIdx));
		}
	}
	
	public void yazdirRastgele10sayi() {
		System.out.println("--- Rastgele 10 sayı: ---");
		set10sayi.forEach(x -> System.out.println(x));
	}
	

}//CLASS ENDS HERE -------