package com.ahmet.list;

import java.util.ArrayList;
import java.util.List;

public class RunnerList { // the Actual Runner we use

	public static void main(String[] args) {
/*
 * List bir interface'dir, genel değişken tanımları yapılabilir.
 * Ancak interface olduğu için nesne türetme işlemi yapılamaz; 
 * nesne türetme işlemini List'in alt sınıfları yapabilir(örneğin:
 * ArrayList, LinkedList, Vector).
 */
		List<String> isimListesi;
		isimListesi = new ArrayList<String>(); // (ArrayList is a class that implements 'List' interface)
		
		// .add() -> ArrayList'e eleman eklemek:
		isimListesi.add("Muhammet"); 
		isimListesi.add("Deniz");

		// .get() -> ArrayList elemanlarını getirmek ('get' metodu ile):
		System.out.println("1. kayıt: " + isimListesi.get(0)); 
		System.out.println("2. kayıt: " + isimListesi.get(1));
		System.out.println("----");
		
		// .add() -> Araya eleman ekleme (index belirterek):
		isimListesi.add(1, "Canan"); 
		
		System.out.println("1. kayıt: " + isimListesi.get(0));
		System.out.println("2. kayıt: " + isimListesi.get(1));
		System.out.println("3. kayıt: " + isimListesi.get(2));
		
		// .remove() -> ArrayList içinde kayıt silmek:
		isimListesi.remove(2); // (1. yöntem: index belirterek silmek)
		isimListesi.remove("Muhammet"); // 2. yöntem (removes the first occurrence of "Muhammet")
		
		
		// Kayıtları Listeleme Yöntemleri 
		// önce bikaç tane eleman ekleyelim:
		isimListesi.add("Hakkı");
		isimListesi.add("Tufan");
		isimListesi.add("Güneş");
		isimListesi.add("Bahar");
		isimListesi.add("Yeşim");
		
		System.out.println("Current size: " + isimListesi.size());
		for(int i=0; i<isimListesi.size(); i++) {
			System.out.println((i+1) + ". kayıt......: " + isimListesi.get(i));
		}
		// for each:
		for(String isim : isimListesi) {  // genelde bunu kullanırız.
			System.out.println("İsim: " + isim);
		}
		
/*
 * Lambda Functions: Listelerinizde barındırılan objelerin
 * metotlarını foreach ile dönerken çağırarak çalıştırabilirsiniz.
 */
		isimListesi.forEach(System.out::println); // pay att: '::' . [this line does the same thing as the above for-each loop]. println 'string' metotları yazdırır, başka şeyleri yazdırmaz. isimListesi'nin içinde string varsa yazdırır.
		System.out.println("5) ------------------");
		
/*
 * İki Listeyi Birleştirmek.  addAll() metodu kullanırız. Dikkat: İki
 * listenin de aynı türden olması gerekir.
 */
		List<String> muhasebePersonelleri = new ArrayList<String>();
		List <String> insanKaynaklariPersonelleri = new ArrayList<String>();
		List <String> teknikPersoneller = new ArrayList<String>();
		muhasebePersonelleri.add("Ahmet");
		muhasebePersonelleri.add("Halit");
		muhasebePersonelleri.add("Tekin");
		insanKaynaklariPersonelleri.add("Bahar");
		insanKaynaklariPersonelleri.add("Türkan");
		teknikPersoneller.add("Aydın");
		teknikPersoneller.add("Murat");
		
		List<String> birlestirilmisListe = new ArrayList<String>();
		
		// addAll() -> iki listeyi birleştirir. sıra ile, listenin sonuna ekleme  yapar:
		birlestirilmisListe.addAll(muhasebePersonelleri);
		birlestirilmisListe.addAll(insanKaynaklariPersonelleri);
		// addAll(index, list) ile index belirterek araya yeni liste sokma:
		birlestirilmisListe.addAll(3, teknikPersoneller);
		System.out.println("**** PERSONEL LİSTESİ ***");
		birlestirilmisListe.forEach(System.out::println);
		
		// Clear Metodu: listeyi temizler. 
		birlestirilmisListe.clear();
		System.out.println("Clear çalıştı");
		System.out.println("size...:" + birlestirilmisListe.size());
		birlestirilmisListe.forEach(System.out::println); // doesn't show anything; list is empty.
		System.out.println("6) ------------------------");
		
		// 'contains(..)' --> aranılan değeri içeriyor mu?
		// Not: eğer aranılan değer belli bir sınıftan ise, sınıf içindeki
		// parametrelerin birebir eşleşmesi gerekir;
		// örn:  User -> ad, soyad, telefon
		if(isimListesi.contains("Güneş")) {
			System.out.println("Aradığınız isim listede mevcut.");
		}else {
			System.out.println("Böyle bir isim bulunmamaktadır.");
		}
		
		// indexOf(..)  -> aranılan değerin index'ini döner.
		int index = isimListesi.indexOf("Yeşim");
		System.out.println("Yeşim kullanıcısının indexi...: " + index);
		
		System.out.println("7) ------------------------");
		// lastIndexOf(..)  -> aramaya sondan başlayarak hangi index'te bulunduğunu döner.
		index = isimListesi.lastIndexOf("Aydın");
		System.out.println(index);
		
		// isEmpty()  -> (boolean) bir listenin içinde değer olup olmadığını döner.		
		boolean listeBosMu = isimListesi.isEmpty();
		System.out.println("Liste boş mu?: " + listeBosMu);
		System.out.println("8) ------------------------");		
		
		isimListesi.forEach(System.out::println);
		System.out.println("9) ------------------------");
		
		// .set(index, value) --> overwrites the element at the specific index in a list.
		isimListesi.set(5, "Zeynep");
		isimListesi.forEach(System.out::println);	
		
		// .subList(index, index) --> bir listenin içinden bir kesitini almaya yarar.
		List<String> altListe = isimListesi.subList(2, 4);
		System.out.println("subList(index, index) Kullanımı:");
		altListe.forEach(System.out::println);
		
		
	}//main ends here

}
