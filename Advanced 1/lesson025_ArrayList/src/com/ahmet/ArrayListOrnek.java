package com.ahmet;

import java.util.ArrayList;

public class ArrayListOrnek {
/*
 * Bir tane String arrayList'i oluşturalım; * 
 * Ankara
 * Bursa
 * Antalya
 * Artvin
 * Erzurum
 * Karaman
 * 
 * 'An' ile başlayanları listeden çıkartıp listeyi yazdıralım.
 * 
 * 
 */
	
	public static void main(String[] args) {
		
		ArrayList<String> sehirler = new ArrayList<String>();
		sehirler.add("Ankara");
		sehirler.add("Bursa");
		sehirler.add("Antalya");
		sehirler.add("Artvin");
		sehirler.add("Erzurum");
		sehirler.add("Karaman");
		
//		for(int i=0; i<sehirler.size(); i++) { // eleman silme işlemini bu şekilde normal for loop ile yapıtığımız zaman düzgün siler; for-each loop'u ile yaparsak hata verir: "Concurrent Modification Exception".
//			if(sehirler.get(i).startsWith("An")) {
//				sehirler.remove(sehirler.get(i));  // 'remove' metodunu burda kullanıyoruz.
//			}			
//		}
		
//		for(int i=0; i<sehirler.size(); i++) { 
//			if(sehirler.get(i).startsWith("An")) {
//				sehirler.set(i, "xxx"); // "An" ile başlayanları "xxx" ile değiştirdik.
//			}			
//		}
		
//		for(int i=0; i<sehirler.size(); i++) {    // 2. Yöntem- "An" ile başlayanları "xxx" ile değiştirmek için 2'nci bir yöntem. 
//			if(sehirler.get(i).startsWith("An")) {
//				sehirler.remove(sehirler.get(i)); 
//				sehirler.add(i, "xxx");
//			}			
//		}
		
		for(String sehir : sehirler) {  // for-each ile 
			if(sehir.startsWith("An")) {
				sehirler.set(sehirler.indexOf(sehir), "xxx");  // 3. Yöntem - [for-each ile] "An" ile başlayanları "xxx" ile değiştirmek için 3'ncü bir yöntem.
			}
		}
		
		for(String sehir : sehirler) {
			System.out.println(sehir);
		}
		
		
		
	}//main ends here
	
	
}//class ends here
