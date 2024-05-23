package pide1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * String bir kuyruk tanımlayacağız.
 * Bu kuyruğa 10-12 tane isim ekleyeceğiz.
 * Random 1-10 arası sayı üreteceğiz (pide sayımız olcak bu).
 * Kuyruğa göre pideleri dağıtacağız.
 * Pide bittiğinde "Pide bitti" yazdıracağız.
 * Bir de pide alamayanları yazdıralım.
 */
public class RamazanPidesiKuyrugu {
	
	Queue<Kisi> kuyruk = new LinkedList<Kisi>();
	
	
	
	public static void main(String[] args) {
		
		RamazanPidesiKuyrugu rpk = new RamazanPidesiKuyrugu();
		rpk.kuyrugaInsanlarEkle(11);
		rpk.pideleriOlusturVeVer();
		rpk.pideAlamayanlariYazdir();
		
		
	}//MAIN ENDS HERE ----------	

	public void kuyrugaInsanlarEkle(int kisiSayisi) {
		kuyruk.add(new Kisi("Ahmet"));
		kuyruk.add(new Kisi("Murat"));
		kuyruk.add(new Kisi("Hasan"));
		kuyruk.add(new Kisi("Ozan"));
		kuyruk.add(new Kisi("Zeliha"));
		kuyruk.add(new Kisi("Sümeyye"));
		kuyruk.add(new Kisi("Ezgi"));
		kuyruk.add(new Kisi("Gizem"));
		kuyruk.add(new Kisi("Oğuz"));
		kuyruk.add(new Kisi("Atilla"));
		kuyruk.add(new Kisi("Mustafa"));
	}
	
	public void pideleriOlusturVeVer() {
		Random random = new Random();
		int pideSayisi = random.nextInt(1,11);
		for(int i=0; i<pideSayisi; i++) {
			Pide pide = new Pide();
			kuyruk.peek().setPide(pide);
			kuyruk.remove();
		}
		System.out.println("Pide bitti :(");
	}
	
	public void pideAlamayanlariYazdir() {	
		System.out.println("--- Pide Alamayanlar: ---");
		while(!kuyruk.isEmpty()) {
			System.out.println(kuyruk.peek().getAd());
			kuyruk.remove();
		}
	}

	
	
}//CLASS ENDS HERE --------
