package com.ahmet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOrnek {
/*
 * String bir set'imiz olsun.
 * Dışarıdan bir kategori istediğimiz metot olsun.
 * Bu kategorileri set'imize ekleyelim.
 * 
 * Eğer daha önce eklemişsek "Böyle bir kategori zaten mevcut" diye
 * bir çıktı versin.
 * 
 * Setimizi yazdıralım.
 */
	public static void main(String[] args) {
		
		Set<String> kategoriler = new HashSet<>();  // HashSet içindeki şeyleri yazdırırken karışık sırada yazdırır.
//		Set<String> kategoriler = new LinkedHashSet<>();  // LinkedHashSet içindeki şeyleri yazdırırken eklendiği sırada yazdırır.
		kategoriEkle2("Sebze", kategoriler);
		kategoriEkle2("Süt Ürünleri", kategoriler);
		kategoriEkle2("Sebze", kategoriler);
		kategoriEkle2("Tahıl", kategoriler);
		setiYazdir(kategoriler);
	}
	
	public static void kategoriEkle(String yeniKategori, Set<String> categories) {		
		if(categories.contains(yeniKategori)) {				
			System.out.println(yeniKategori + " zaten mevcut, tekrar ekleyemezsiniz !!!");
		}else {
			categories.add(yeniKategori);
			System.out.println(yeniKategori + " başarılı bir şekilde eklendi.");
		}			
	}
	
	public static void kategoriEkle2(String yeniKategori, Set<String> categories) {		
		if(categories.add(yeniKategori)) { // if successfully added, returns 'true'; if not, returns false.
			System.out.println(yeniKategori + " başarılı bir şekilde eklendi.");			
		}else {
			System.out.println(yeniKategori + " zaten mevcut, tekrar ekleyemezsiniz !!!");
		}			
	}
	
	public static void setiYazdir(Set<String> categories) {
		System.out.println("--- Set'teki Elemanlar: ---");
		categories.forEach(System.out::println);
	}

}
