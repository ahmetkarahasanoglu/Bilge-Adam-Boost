package banka;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Müşteri kuyruğumuz olacak.
 * Bu müşteri kuyruğuna müşteri ekleyeceğiz, sonra da
 * müşterileri sırayla işleme alacağız. 
 * 65 yaş üstü öncelikli olsun.
 */
public class Banka {
	
	Queue<Musteri> musteriler = new PriorityQueue<>();
	
	// CONSTRUCTOR:
	public Banka() {
		musteriEkle();
	}
		
	public static void main(String[] args) {
		Banka banka = new Banka();
		banka.kuyruguYazdir();
	}

	public void musteriEkle() {
		musteriler.offer(new Musteri("Mustafa", 35));
		musteriler.offer(new Musteri("Kemal", 67));		
		musteriler.offer(new Musteri("Okan", 70));
		musteriler.offer(new Musteri("Gizem", 24));
		musteriler.offer(new Musteri("Zeliha", 66));
		
		
	}
	
	public void kuyruguYazdir() {
		while(!musteriler.isEmpty()) {
			System.out.println(musteriler.poll());
		}
	}
	
}
