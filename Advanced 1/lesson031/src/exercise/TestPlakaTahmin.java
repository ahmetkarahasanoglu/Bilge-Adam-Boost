package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TestPlakaTahmin {
	
	static PlakaTahmin plakaTahmin = new PlakaTahmin();	
	static Scanner sc = new Scanner(System.in);
	int oyunNo = 0;	

	public static void main(String[] args) {		
		
		plakaTahmin.mapOlustur(plakaTahmin.iller);
//		plakaTahmin.yazdir(plakaTahmin.sehirMap);
		
		TestPlakaTahmin testPlakaTahmin = new TestPlakaTahmin();
		testPlakaTahmin.menu();
		sc.close();
	}//MAIN ENDS HERE ---------

	public void menu() {
		int secim;
		do {
			System.out.println("******* MENÜ *******");
			System.out.println("1) Oyuna Başla");
			System.out.println("2) Eski Tahminlerim");
			System.out.println("0) ÇIKIŞ");			
			secim = secimYap();
			switch(secim) {
			case 1:
				oyunaBasla();
				break;
			case 2:
				eskiTahminleriGoster();
				break;
			case 0 :
				System.out.println("Çıkış yapılıyor...");
				break;
			default:
				System.out.println("Geçersiz seçim!");
			}
		}while(secim != 0);
	}
	
	public int secimYap() {
		sc = new Scanner(System.in);
		System.out.println("Lütfen seçim yapınız: ");
		int secim = sc.nextInt();
		sc.nextLine(); // dummy		
		return secim;
	}
	
	public void oyunaBasla() {
		oyunNo++;
		Random random = new Random();
		int rastgelePlaka = random.nextInt(1,82);			
		System.out.println("Her oyun için 3 tahmin hakkınız bulunmaktadır.");
		List<String> list = new ArrayList<>();
		int hak = 3;		
		while(hak > 0) {			
			String sehirTahmin = sehirTahminAl(rastgelePlaka);
			String dogruSehir = plakaTahmin.sehirMap.get(rastgelePlaka);			
			list.add(sehirTahmin);									
			if(dogruSehir.equalsIgnoreCase(sehirTahmin)) {
				System.out.println("Tebrikler, doğru bildiniz.");
				break;
			}else {
				System.out.println("Cevabınız yanlış.");
				hak--;
				System.out.println("Kalan hakkınız: " + hak);
			}
			plakaTahmin.tahminler.put(oyunNo, list);
			if(hak == 0) {
				System.out.println("Doğru Cevap: " + dogruSehir);
				System.out.println("- Oyun sonlandı. -");
			}			
		}		
	}
	
	public String sehirTahminAl(int rastgelePlaka) {
		sc = new Scanner(System.in);
		System.out.print(rastgelePlaka + " hangi ilimizin plakasıdır?: ");		
		String ilTahmin = sc.nextLine();		
		return ilTahmin;
	}
	
	public void eskiTahminleriGoster() {
		plakaTahmin.tahminler.forEach((k,v)->System.out.println(k + ". oyun tahminleri --> " + v));
	}
	
}//CLASS ENDS HERE -------
