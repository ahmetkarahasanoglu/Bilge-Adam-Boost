package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/* Dışarıdan bir string değeri gireceğiz.
 * Bir map içine atacağız. örn: 'merhaba' kelimesi.
 * harfler 'key'ler olacak. Kaç kere geçtiği de 'value' olacak.
 * 
 * m=1
 * e=1
 * r=1
 * h=1
 * a=2
 * b=1
 */
public class HarfFrekansiBulma {
	
	static Scanner sc;
	
	public static void main(String[] args) {
		
		String kelime = inputAl();
		Map<Character, Integer> map = harfFrekansiBul(kelime);
		/*Printing map (plain map): */				System.out.println("Printing map (plain map):");
		System.out.println(map);
		/*Printing With EntrySet - forEach: */  	System.out.println("Printing With EntrySet - forEach:");
		map.entrySet().forEach(System.out::println);
		/*Printing With EntrySet - for( : ) */		System.out.println("Printing With EntrySet - for( : )"); 		
		for(Map.Entry<Character, Integer> frequency : map.entrySet()) { // Sadece 'map' yazarsak hata veriyor: "iterable değil" diyor. Onun yerine iterable olan 'map.entrySet()' kullanıyoruz.
			System.out.println(frequency.getKey() + "-->" + frequency.getValue());
		}
		/*Printing With forEach((k,v)->....*/		System.out.println("Printing With forEach((k,v)->....");
		map.forEach((k,v) -> System.out.println(k + "==>" + v));
		
	}//MAIN ENDS HERE --------
	
	public static String inputAl() {
		sc = new Scanner(System.in);
		System.out.print("Kelime giriniz: ");
		String input = sc.nextLine();
		return input;
	}
	
	public static Map<Character, Integer> harfFrekansiBul(String kelime) {
		Map<Character, Integer> map = new LinkedHashMap<>();
//		for(char c : kelime.toCharArray()) {  // another version of the below block.
//			if(map.containsKey(c)) {
//				map.put(c, map.get(c)+1);
//			}else {
//				map.put(c, 1);
//			}
//		}
		for(int i=0; i<kelime.length(); i++) {
			Character c = kelime.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
//				map.replace(c, map.get(c)+1);  // this works too (as an alternative to 'put' method).
			}else {
				map.put(c, 1);
			}
		}
		return map;
	}
	
}//CLASS ENDS HERE -------
