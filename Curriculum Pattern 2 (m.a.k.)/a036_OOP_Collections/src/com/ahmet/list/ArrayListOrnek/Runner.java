package com.ahmet.list.ArrayListOrnek;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.ad = "Muhammet";
		ogrenci.soyad = "HOCA";		
		ogrenci.notlar.matematik.add(60);
		ogrenci.notlar.matematik.add(90);
		ogrenci.notlar.matematik.add(78);
		ogrenci.notlar.matematik.forEach(System.out::println);
		
		// 2. YÖNTEM (biraz daha karışık bir yöntem bu):
		Ogrenci ogr =  new Ogrenci();
		ogr.ad = "Canan";
		ogr.soyad = "BAKIMLI";
		List<Integer> matematik = new ArrayList<Integer>();
		matematik.add(90);
		matematik.add(63);
		matematik.add(77);
		DersNotlari notlar = new DersNotlari();
		notlar.matematik = matematik;
		ogr.notlar = notlar;

	}//main ends here

}//class ends here
