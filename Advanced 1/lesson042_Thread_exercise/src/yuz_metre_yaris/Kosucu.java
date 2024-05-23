package yuz_metre_yaris;

import java.util.Stack;

/*
 * Kosucu bir thread olacak.
 * Koşucunun -> ismi, mesafe, süre.
 * 
 * ismi ile bir koşucu oluşturabileceğiz.
 * thread için bir metot yazacaz.
 * Bu metotta her koşucu 100 metreye kadar koşacak
 * ve döngü her çalıştığında 1 metre mesafe alacak.
 * Her döngü arasında metodumuz 200 milisaniye uyusun (beklesin)
 * ve her 10 metrede bir bilgilendirme mesajı yazdıralım.
 * mustafa --> 10.metrede
 * mustafa --> 20.metrede
 * Metodun sonunda da;
 * mustafa adlı koşucu 100 metreyi 20000 milisaniyede koştu.
 * 
 * - YuzMetreYarisi class'ında 5 tane koşucu oluşturup 
 * thread'leri çalıştıralım.
 */
public class Kosucu implements Runnable {
	
	String isim;
	int mesafe;
	long sure;	
	long baslangicZamani;
	
	// CONSTRUCTOR:
	public Kosucu(String isim, long baslangicZamani) {
		this.isim = isim;
		this.mesafe= 0;
		this.baslangicZamani = baslangicZamani;
		}

	
	@Override
	public void run() {
		baslangicZamani = System.currentTimeMillis();
		for(int i=1; i<=100; i++) {
			mesafe = mesafe + 1;
			if(i%10 == 0) {
				System.out.println(isim + " --> " + i + ". metrede");
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long bitisZamani = System.currentTimeMillis();
		sure = bitisZamani - baslangicZamani;
		System.out.println(isim + " adlı koşucu " + mesafe + " metreyi " + sure + " milisaniyede koştu.");
		
	}
	
	@Override
	public String toString() {
		return "Kosucu [isim=" + isim + ", mesafe=" + mesafe + ", sure=" + sure + "]";
	}

	
}
