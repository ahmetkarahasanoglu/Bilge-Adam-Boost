package com.ahmet.map;

import java.util.HashMap;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {
/*
 * *** MAP ***
 * Key-Value şeklinde çalışır.
 * Key: String, Integer vs.
 * Value: Herhangi bir değer olabilir; String, Integer, any class.
 */
		Map<Integer, String> sinifListesi = new HashMap<Integer, String>();
		sinifListesi.put(1, "1-A");
		sinifListesi.put(2, "1-B");
		sinifListesi.put(3, "1-C");
		sinifListesi.put(4, "2-A");
		sinifListesi.put(5, "2-B");
		// * get(key) -> map içindeki anahtar değeri yazarak onun value'sunu elde ederiz:
		
		System.out.println(sinifListesi.get(3));
		System.out.println("-------------------------");
		
		for(int i=0; i<=sinifListesi.size(); i++) {
			// NOT: * getOrDefault(key, defaultValue) -> 
			System.out.println(sinifListesi.getOrDefault(i, "emptyyyy")); // we can print whatever we want for a 'null' value.
		}

	}//main ends here

}//class ends here
