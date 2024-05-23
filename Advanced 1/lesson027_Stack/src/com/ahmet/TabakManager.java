package com.ahmet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class TabakManager {
	
	ArrayList<Tabak> tabaklar = new ArrayList<>();
	Stack<Tabak> temizTabaklar;
	Stack<Tabak> kirliTabaklar;
	
	public TabakManager() {
		temizTabaklar = new Stack<>();
		kirliTabaklar = new Stack<>();
	}

	public static void main(String[] args) throws InterruptedException {
		
		TabakManager tabakManager = new TabakManager();
		
		for(int i=0; i<10; i++) {
			tabakManager.tabaklar.add(new Tabak());
		}
		
		tabakManager.kirlileriVeTemizleriAyir(tabakManager.tabaklar, tabakManager);
		
		for(int i=0; i<50; i++) {
			tabakManager.rastgeleIslemKullanVeyaTemizle();
			Thread.sleep(1000);
		}
		
//		tabakManager.tabakTemizle();
//		tabakManager.tabakTemizle();
//		tabakManager.kullan();		
		
		System.out.println("Kirli tabak sayısı: " + tabakManager.kirliTabaklar.size());
		System.out.println("Temiz tabak sayısı: " + tabakManager.temizTabaklar.size());

	}//MAIN ENDS HERE -------------------------
	
	public void kirlileriVeTemizleriAyir(ArrayList<Tabak> tabaklar, TabakManager tbkManager) {
		for(Tabak tabak : tabaklar) {
			if(tabak.getIsDirty()) {
				tbkManager.kirliTabaklar.add(tabak);
			}else {
				tbkManager.temizTabaklar.add(tabak);
			}
		}
	}
	
	public void tabakTemizle() {
		if(!kirliTabaklar.isEmpty()) {
			Tabak tabak = kirliTabaklar.pop();
			tabak.setIsDirty(false);
			temizTabaklar.push(tabak);
			System.out.println(tabak.getId() + " id'li tabak temizlenmiştir.");
		}else {
			System.out.println("Kirli tabak kalmamış.");
		}		
	}
	
	public void kullan() {
		if(!temizTabaklar.isEmpty()) {
			Tabak tabak = temizTabaklar.pop();
			tabak.setIsDirty(true);
			kirliTabaklar.push(tabak);
			System.out.println(tabak.getId() + " id'li tabak kullanılmıştır.");
		}else {
			System.out.println("Temiz tabak kalmamış.");
		}	
	}
	
	/*
	 * Rastgele 1 ya da 2 gelecek bir seçim üreteceğiz,
	 * bu seçime göre metotta bir işlem seçtireceğiz;
	 * 1 gelmişse temizle, 2 gelmişse kullan metodu çalışsın.
	 */
	public void rastgeleIslemKullanVeyaTemizle() {
		Random random = new Random();
		int choice = random.nextInt(1,3);
		if(choice == 1) {
			tabakTemizle();
			System.out.println("Choice is 1, tabakTemizle() has been run.");
		}else if(choice == 2) {
			kullan();
			System.out.println("Choice is 2, kullan() has been run.");
		}
	}

}//CLASS ENDS HERE -------
