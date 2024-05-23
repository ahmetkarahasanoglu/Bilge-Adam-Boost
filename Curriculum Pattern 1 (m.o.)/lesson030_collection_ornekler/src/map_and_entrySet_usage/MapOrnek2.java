package map_and_entrySet_usage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 1) öğrenci ve notlardan map oluşturun.
 * 2) öğrenciyi çağırdığımda bana notu dönsün.
 * 3) map'i yazdıralım.
 */

public class MapOrnek2 {
	
	String[] ogrenci = { "Ayşe", "Ece", "Mahmut" };
	int[] notlar = { 60, 80, 70 };
	Integer[][]notlar2 = { {50,50,60}, {80,90,70}, {25,75,80} };
	
	Map<String, Integer> ogrenciNotlari = new HashMap<>();
	Map<String, Integer[]> ogrenciNotlari2 = new HashMap<>();
	Map<String, List<Integer>> ogrenciNotlari3 = new HashMap<>();
	
	public static void main(String[] args) {
		MapOrnek2 mapOrnek2 = new MapOrnek2();
		mapOrnek2.mapOlustur();
		mapOrnek2.mapOlustur2();
		mapOrnek2.mapOlustur3();
		
		
		System.out.println(mapOrnek2.ogrenciNotlari.get("Ece")); // answer of question 2.
		System.out.println();
		
		/* Printing the map (version 1): */			System.out.println("*** Printing the map (version 1): ***");
		mapOrnek2.ogrenciNotlari.forEach((k,v)->System.out.println(k + " --> " + v)); // answer of question 3.
		System.out.println();
		/* Printing the map (version 2): */			System.out.println("*** Printing the map (version 2) ***");
		for(Map.Entry<String, Integer> element : mapOrnek2.ogrenciNotlari.entrySet()) { // 'Entry': is an interface of Map that represents key-value pair within a map; instances of this 'Entry' is obtained by calling the 'entrySet()' method on a map. In other words, to print the map, we convert the map to an entrySet. With the use of Entry, we can use 'getKey()' and 'getValue()' methods below. Otherwise, we can't get the key of a map.
			System.out.println(element.getKey() + "--->" + element.getValue());
		}
		System.out.println();
		
		/* Printing ogreciNotlari2 with 'forEach((k,v)->...' by using  'Arrays.toString(v)'  [writing just (v) prints the memory address of 3-element array.*/		System.out.println("*** Printing ogreciNotlari2 with 'forEach((k,v)->...' by using  'Arrays.toString(v)'  [writing just (v) prints the memory address of 3-element array. ***");
		mapOrnek2.ogrenciNotlari2.forEach((k,v)->System.out.println(k + " --> " + Arrays.toString(v)));
		System.out.println();
		
		/* Printing ogreciNotlari2 with 'entrySet' */		System.out.println("*** Printing ogreciNotlari2 with 'entrySet' ***");
		for (Entry<String, Integer[]> entry : mapOrnek2.ogrenciNotlari2.entrySet()) {
		    System.out.print(entry.getKey() + " --> ");
		    Integer[] grades = entry.getValue();
		    for (Integer grade : grades) {
		        System.out.print(grade + " ");
		    }
		    System.out.println();
		}
		
		/* Printing ogrenciNotlari3 - Map<String, List<Integer>> */   System.out.println("*** Printing ogrenciNotlari3 - Map<String, List<Integer>> ***");
		mapOrnek2.ogrenciNotlari3.forEach((k,v)->System.out.println(k + " --> " + v));
			// --- Teacher's way: ---
//		mapOrnek2.ogrenciNotlari3.forEach((k,v)->{
//			System.out.print(k + ": ");
//			for(int i=0; i<v.size(); i++) {
//				System.out.print(v.get(i) + ", ");
//			}
//			System.out.println();
//		});
			// --- Teacher's way, version 2: ---
//		for(Entry<String, List<Integer>> ogrenciler : mapOrnek2.ogrenciNotlari3.entrySet()) {
//			System.out.print(ogrenciler.getKey() + " ==> ");
//			for(Integer not : ogrenciler.getValue()) {
//				System.out.print((not + " "));
//			}
//			System.out.println();
//		}

		
		
	}//MAIN ENDS HERE -----

	public void mapOlustur() {
		for(int i=0; i<ogrenci.length; i++) {
			ogrenciNotlari.put(ogrenci[i], notlar[i]);
		}		
	}
	
	public void mapOlustur2() {
		for(int i=0; i<ogrenci.length; i++) {
			ogrenciNotlari2.put(ogrenci[i], notlar2[i]);
		}		
	}
	
	public void mapOlustur3() {
		for(int i=0; i<ogrenci.length; i++) {//			
			ogrenciNotlari3.put(ogrenci[i], Arrays.asList(notlar2[i]));
		}
		// Teacher's Method://		
//		for(int i=0; i<ogrenci.length; i++) {
//			List<Integer> list = new ArrayList<>();
//			for(int j=0; j<notlar2[i].length; j++) {
//				list.add(notlar2[i][j]);
//			}
//			ogrenciNotlari3.put(ogrenci[i], list);
//		}
	}
	
	
}//CLASS ENDS HERE -----
