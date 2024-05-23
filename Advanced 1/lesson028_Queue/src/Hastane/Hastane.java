package Hastane;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hastane {
	
	Queue<Hasta> kuyruk = new PriorityQueue<>();
	
	static Hastane hastane = new Hastane();
	
	public static void main(String[] args) {
		
		hastane.kuyruk.offer(new Hasta("Ahmet", "Yanık"));
		hastane.kuyruk.offer(new Hasta("Namık", "Baş Ağrısı"));
		hastane.kuyruk.offer(new Hasta("Rıfkı", "Apandisit"));
		hastane.kuyruk.offer(new Hasta("Selami", "Baş Ağrısı"));
		hastane.kuyruk.offer(new Hasta("Nedim", "Apandisit"));
		
		kuyrukYazdir();
		
	}//MAIN ENDS HERE ---------
	
	public static void kuyrukYazdir() {
		while(!hastane.kuyruk.isEmpty()) {
			System.out.println(hastane.kuyruk.poll());
		}
	}

}//CLASS ENDS HERE -------
