package pide2;

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
		rpk.kuyrugaInsanlariEkle(new Random().nextInt(12));
		rpk.pideleriOlusturVeVer();
		rpk.pideAlamayanlariYazdir();
		
		
	}//MAIN ENDS HERE ----------	

	public void kuyrugaInsanlariEkle(int kisiSayisi) {
		for(int i=0; i<kisiSayisi; i++) {
			Kisi kisi = new Kisi();
			kuyruk.add(kisi);
		}
	}
	
	public void pideleriOlusturVeVer() {
		Random random = new Random();
		int pideSayisi = random.nextInt(1,11);		
		while(!kuyruk.isEmpty() && pideSayisi>0) {
			Pide pide = new Pide();
			kuyruk.peek().setPide(pide);
			pideSayisi--;
			kuyruk.remove();
		}			
		if(pideSayisi == 0) {
			System.out.println("Pide bitti :(");
		}		
	}
	
	public void pideAlamayanlariYazdir() {		
		while(!kuyruk.isEmpty()) {
			System.out.println(kuyruk.remove());
		}
	}

	
	
}//CLASS ENDS HERE --------
