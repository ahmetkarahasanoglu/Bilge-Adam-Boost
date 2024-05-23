package com.ahmet.map;

import java.util.Map;
import java.util.TreeMap;

public class RunnerMap {

	public static void main(String[] args) {
		
		Map<String, String> urunStok = new TreeMap<String, String>();
		urunStok.put("STK0001", "Şeker");
		urunStok.put("STK0002", "Un");
		urunStok.put("STK0003", "Makarna");
		urunStok.put("STK0004", "Bal"); // Key'ler düzenli sıralandığı için klasik for döngüsüsyle yazdırabiliriz.
		
		for(int i=1; i<=urunStok.size(); i++) {
			System.out.println(urunStok.get("STK000" + i)); 
		}
		
		System.out.println("---------------------------");
		
		Map<String, String> urunStok2 = new TreeMap<String, String>();
		urunStok2.put("STK0001FT", "Şeker");
		urunStok2.put("STK0002ER", "Un");
		urunStok2.put("STK0009RE", "Makarna");
		urunStok2.put("STK00011YT", "Bal");  // We can't print these values with classic 'for' loop; the keys are in a complex lineup.
		urunStok2.put("STK001", "A Marka Soda");
		if(urunStok2.containsKey("STK001")) { // Aynı key ile yeni eklemeler yapıldığında bu key'e ait değerin üzerine yazılır. Eğer üzerine yazmak istemez isek ne yapalım, 'containsKey' metodu ile if kontrolü yapabiliriz.
			System.out.println("Dikkat böyle bir key vardır.");			
		}else {
			urunStok2.put("STK001", "B Marka Soda");
		}
		
		urunStok2.remove("STK0002ER"); // Un'u sildik.
		
		urunStok2.forEach((k,v)->System.out.println(k + " : " +v)); // Bu şekilde 'key' ve 'value'ları belirterek yazdırabiliriz.
		

	}

}
