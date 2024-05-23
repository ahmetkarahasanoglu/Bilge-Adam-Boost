package com.ahmet.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Runner {

	public static void main(String[] args) {
		/*
		 * **** QUEUE (KUYRUK) ****
		 * Hastane kuyruğu, kahve kuyruğu
		 * FIFO (First In First Out)
		 * - Priority Queue'da önceliğe göre sıralama yapılır,
		 *   kuyruktan öncelik sırasına göre nesneler çıkartılır.
		 *   '--> Sayılarda  -> 0....9
		 *        Metinlerde -> a....z
		 */
		
		PriorityQueue<Integer> kuyruk = new PriorityQueue<Integer>();
		kuyruk.add(600);
		kuyruk.add(1);
		kuyruk.add(150);
		kuyruk.add(48);
		kuyruk.add(55);
		kuyruk.add(60);
		
//		System.out.println("--- Sayı Kuyruğu ---");
		
//		kuyruk.forEach(System.out::println);
		
//		for(Integer num : kuyruk) {
//			System.out.println(num);
//		}
		
		/*
		 * Bir kuyrukta remove() metodu ilk değeri okur ve kuyruktan siler:
		 * 	1. adım => i=0, size=6 -> 1
		 * 	2. adım => i=1, size=5 -> 1
		 * 	3. adım => i=2, size=4 -> 1
		 * 	4. adım => i=3, size=3 -> 1  --> bu adım çalışmaz, sonrasındaki (aşağıdaki) adımlar da çalışmaz. Çünkü i, size'a eşit. 
		 * 	5. adım => i=,  size=  -> 1
		 * 	6. adım => i=,  size=  -> 1
		 * Bu şekilde kuyruk düzgün şekilde okunmaz.
		 */		
//		for(int i=0; i<kuyruk.size(); i++) {
//			System.out.println("Okunan değer.....:" + kuyruk.remove());
//		}
		
//		System.out.println("--- size'ı geçici olarak bi değişkene atayalım, o şekilde düzgün yazdırır:");
//		int sizeHolder = kuyruk.size();
//		for(int i=0; i<sizeHolder; i++) {
//			System.out.println("Okunan değer.....:" + kuyruk.remove());
//		}
		
		System.out.println("--- Do-while ile kuyruk okuma: ---");
		do {
			System.out.println(kuyruk.remove());  // each remove() operation in 'priority queue' retrieves the smallest remaining element (returns it and deletes it).
		}while(kuyruk.size()>0);
		
		
		

		
		
	}//MAIN ENDS HERE

}//CLASS ENDS HERE
