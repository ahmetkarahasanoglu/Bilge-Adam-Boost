package com.ahmet.list.vector;

import java.util.List;
import java.util.Vector;

public class RunnerVector {

	public static void main(String[] args) throws InterruptedException {
		String[] dizi;
		/*
		 * **** VECTOR ****
		 * Vektör, senkron şekilde çalışan bir listedir.
		 *   Senkron İşlemler -> işlemler sıra ile yapılır, biri
		 *   					 biter, diğeri başlar.
		 *   Asenktron İşlemler -> İşlemler sıra ile başlatılır
		 *    					   ve aynı anda devam eder. Yani
		 *    					   bir işlemin bitmesini 
		 *    					   beklemeden başka bir işlem 
		 *    					   başlayabilir.
		 *    Vektor: ArrayList gibidir, farkı vektör'ün senkron
		 *            çalışmasıdır; daha yavaş tamamlar işlemleri.
		 *            Vektör günümüzde pek kullanılmıyor. 
		 *            ArrayList asenkron'dur; en çok kullanılandır.
		 */
		
		Vector<String> vektor = new Vector<String>();
		vektor.add("Muhammet");
		
		List<String> vektorList = new Vector<String>();
		vektorList.add("Ali");
		vektorList.addAll(vektor);
		vektorList.forEach(x->System.out.println(x));
		
		System.out.println("-------------------");
		new Thread(()-> {
			try {
				muzikdinle();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		Thread.sleep(1000L);
		internetegir();
		

	}//MAIN ENDS HERE --------

	private static void muzikdinle() throws InterruptedException {
		System.out.println("Müzik dinliyor...");
		Thread.sleep(2000L);
		System.out.println("Müzik bitti.");
		
	}
	private static void internetegir() {
		System.out.println("İnternette geziniyor.");
		
	}

	

}//CLASS ENDS HERE --------
