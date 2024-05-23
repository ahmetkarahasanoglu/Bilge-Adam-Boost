package com.ahmet.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class RunnerHastaPriorityQueue {

	public static void main(String[] args) {
/*
 * Bir hastane kuyruk sistemi yazacağız. 
 * 0-7 ve 65+ üzeri hastalar önceliğe sahip, diğerleri sırayla
 * alınacak. 
 */
		Queue<Hasta> hastaKuyrugu = new PriorityQueue<Hasta>();
		
		Hasta hasta = new Hasta("Ayşe Teyze", "567377435", 85);
		hastaKuyrugu.add(hasta);
		
		hastaKuyrugu.add(new Hasta("Ali", "657562534", 19));
		hastaKuyrugu.add(new Hasta("Tekin", "456346736", 1));
		hastaKuyrugu.add(new Hasta("Bahar", "467566377", 5));
		hastaKuyrugu.add(new Hasta("Ecrin", "345635734", 62));
		
//		hastaKuyrugu.forEach(System.out::println); // forEach'le yazdırırken sıralamada karışıklık oluyo. do-while ile düzgün yazdırılıyo.
		
		System.out.println("--- do-while ile okumak ---");
		do {  		// do-while ile düzgün yazdırılıyo sıralama
			System.out.println(hastaKuyrugu.remove());
		}while(hastaKuyrugu.size() > 0); // IMPORTANT USAGE !!!!!!!
		
		
	}//MAIN ENDS HERE

}//CLASS ENDS HERE
