package yuz_metre_yaris;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class YuzMetreYaris {
	
	public static void main(String[] args) {
		
		long baslangicZamani = System.currentTimeMillis();
		
		Kosucu kosucu1 = new Kosucu("Mustafa", baslangicZamani);
		Kosucu kosucu2 = new Kosucu("Mert", baslangicZamani);
		Kosucu kosucu3 = new Kosucu("Berkin", baslangicZamani);
		Kosucu kosucu4 = new Kosucu("Arda", baslangicZamani);
		Kosucu kosucu5 = new Kosucu("Murat", baslangicZamani);

		List<Kosucu> kosucular = List.of(kosucu1, kosucu2, kosucu3, kosucu4, kosucu5);
		
//		Thread thread1 = new Thread(new Kosucu("Mustafa", baslangicZamani));
		Thread thread1 = new Thread(kosucu1);
		Thread thread2 = new Thread(kosucu2);
		Thread thread3 = new Thread(kosucu3);
		Thread thread4 = new Thread(kosucu4);
		Thread thread5 = new Thread(kosucu5);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join(); // 'join': waits for this thread to terminate.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		kosucular.forEach(System.out::println);
		
//		Map<Long, String> myTreeMap = new TreeMap<>(); // sure-isim Map'i. TreeMap: key değerlerini esas alarak alfabetik sıralar.
//		myTreeMap = kosucular.stream()
//				.collect(Collectors.toMap(
//						x -> x.sure, 
//						x -> x.isim
//						));
		
		System.out.println("1)----------------------------");
		
		// --- Other variations of solution with stream():
//		System.out.println("*** YARIŞ SONU SIRALAMA: ***");		
//		Map<String, Kosucu> myTreeMap2 = new TreeMap<>();
//		myTreeMap2 = kosucular.stream()
//				.sorted(Comparator.comparingLong(z -> z.sure))
//				.collect(Collectors.toMap(
//						x -> x.isim, 
//						x -> x,
//						(existing, replacement) -> existing,
//						LinkedHashMap::new
//						));
//		myTreeMap2.forEach((k,v) -> System.out.println(k + " --> " + v));
		System.out.println("2)----------------------------");
		
		// --- another way: [Güzel bir yöntem]
		kosucular.stream()
				.sorted(Comparator.comparingLong(x -> x.sure))
				.forEach(System.out::println);
		
		
	}//MAIN ENDS HERE ----
	
}//CLASS ENDS HERE ----
