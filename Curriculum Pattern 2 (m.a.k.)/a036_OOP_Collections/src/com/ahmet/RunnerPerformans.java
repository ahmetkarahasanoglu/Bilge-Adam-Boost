package com.ahmet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/*
 * - ArrayList'lerde yeni veri oluşturmak kısa sürüyor,
 *    veri içerisinde arama yapmak uzun sürüyor.
 * - Map ve HashSet'te ise yeni veri oluşturmak uzun sürüyor,
 *    veri içerisinde arama yapmak çok kısa sürüyor.
 *    
 * Bilgi: 	1 Second = 1.000 Millisecond
 * 			1 Second = 1.000.000.000 Nanosecond
 */
public class RunnerPerformans {

	public static void main(String[] args) {
		
		System.out.println("******** ArrayList ********");
		Long start = System.nanoTime();
		System.out.println("İşlem başladı");
		ArrayList<String> isimListesi = new ArrayList<String>();
		for(int i=0; i<50_000_000; i++) {
			isimListesi.add("isim" + i);	
		}
		Long stop = System.nanoTime(); // 1 nanosaniye = 1 / 1.000.000.000  saniye
		System.out.println("İşlem süresi......: " + (stop - start));
		start = System.nanoTime();
		System.out.println("Arıyorum....");
		for(int i=0; i<50_000_000; i++) {
			if(isimListesi.get(i).equals("isim" + 49_999_999)) {
				stop = System.nanoTime();
				System.out.println("Buldum.....: " + (stop - start));
				break;
			}
		}
		start = System.nanoTime();
		System.out.println("Stream-Filter arıyorum....");
		String aranan = isimListesi.stream().filter(x->x.equals("isim" + 49_999_999))
				.findFirst().get();
		stop = System.nanoTime();
		System.out.println("Buldum.....: " + (stop - start));
		
		start = System.nanoTime();
		System.out.println("Contains arıyorum....");
		boolean varMi = isimListesi.contains("isim49999999");				
		stop = System.nanoTime();
		System.out.println("Buldum.....: " + (stop - start));		
		System.out.println("------------------------------------------------------");
		
		HashSet<String> hashIsimListesi = new HashSet<String>();		
		
		System.out.println("******** HashSet ********");
		start = System.nanoTime();
		System.out.println("İşlem başladı");
		
		for(int i=0; i<40_000_000; i++) {
			hashIsimListesi.add("isim"+i);
		}
		stop = System.nanoTime();
		System.out.println("Hash İşlem Süresi.....: " + (stop - start));
		start = System.nanoTime();
		System.out.println("Arıyorum....");
		if(hashIsimListesi.contains("isim39999999")) {
			stop = System.nanoTime();
			System.out.println("Hash Buldum....: " + (stop - start)); 
		}
		System.out.println("------------------------------------------------------");
		
		TreeSet<String> treeIsimListesi = new TreeSet<String>();
		System.out.println("******** TreeSet ********");
		start = System.nanoTime();
		System.out.println("İşlem başladı");
		
		for(int i=0; i<40_000_000; i++) {
			treeIsimListesi.add("isim"+i);
		}
		stop = System.nanoTime();
		System.out.println("TreeSet İşlem Süresi.....: " + (stop - start));
		start = System.nanoTime();
		System.out.println("Arıyorum....");
		if(treeIsimListesi.contains("isim39999999")) {
			stop = System.nanoTime();
			System.out.println("TreeSet Buldum....: " + (stop - start)); 
		}
		System.out.println("------------------------------------------------------");
		
		
		
		Map<Integer, String> mapIsimListesi = new TreeMap<Integer, String>();
		System.out.println("******** Map ********");
		start = System.nanoTime();
		System.out.println("İşlem başladı");
		
		for(int i=0; i<5_000_000; i++) {
			mapIsimListesi.put(i, "isim"+i);
		}
		stop = System.nanoTime();
		System.out.println("Hash İşlem Süresi.....: " + (stop - start));
		start = System.nanoTime();
		System.out.println("Arıyorum....");
		aranan = mapIsimListesi.get(4_999_999);		
		stop = System.nanoTime();
		System.out.println("Hash Buldum....: " + (stop - start)); 
		

	}//MAIN ENDS HERE -------

}//CLASS ENDS HERE ------
