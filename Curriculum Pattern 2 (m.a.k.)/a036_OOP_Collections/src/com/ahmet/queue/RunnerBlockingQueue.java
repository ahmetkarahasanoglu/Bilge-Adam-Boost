package com.ahmet.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class RunnerBlockingQueue {

	public static void main(String[] args) {
/*
 * *** ArrayBlockingQueue ***
 * Bazen bir işlemde yapılabilecek adımlar kısıtlıdır.
 * Bir kuyruğun kapasitesi sınırlandırılabilir
 */
		Queue<String> hastalar = new ArrayBlockingQueue<String>(4); // We set the capacity of the queue as '4'.
		hastalar.add("Ahmet");
		hastalar.add("Bahar");
		hastalar.add("Canan");
		hastalar.add("Demet");
//		hastalar.add("Erol"); // 5'nci elemanı eklemeye kalkarsam hata verir: "IllegalStateException" . Çünkü kuyruğun kapasitesini 4 elemanla sınırlandırdık yukarda.
		boolean isAdded = hastalar.offer("Erol"); // offer() -> "teklif var ısrar yok". Kuyrukta boşluk varsa ekler, boşluk yoksa eklemez (hata da vermez).
		if(isAdded) {
			System.out.println("Offer metodu ile kuyruğa eklendi.");
		}else {
			System.out.println("Offer metodu kuyruğa ekleme yapmadı.");
		}
		hastalar.forEach(System.out::println);
		
		

	}//MAIN ENDS HERE

}//CLASS ENDS HERE
