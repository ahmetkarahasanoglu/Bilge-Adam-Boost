package com.ahmet.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {

	public static void main(String[] args) {
		
		List<String> isimler = new ArrayList<String>();
		isimler.add("Ali");
		isimler.add("Ahmet");
		isimler.add("Deniz");
		isimler.add("Bahadır");
		isimler.add("Ali");
		isimler.add("Canan");
		isimler.add("Tekin");
		isimler.add("Şahin");
		isimler.add("Deniz");
		isimler.add("Büşra");		
		isimler.forEach(System.out::println);
		
/*
 * SET ->içerisinde tekrar eden kayıt barındırmaz. Tekil kayıt
 * 		 tutar. Set bir interface olduğu için new'lenemez; bunun
 * 		 yerine bu interface'den miras alan HashSet, TreeSet
 * 		 new'lenebilir. Setler:
 * 		 - boş kayıt bulundurabilirler (null).
 * 		 - karma denilen bir yapı kullanarak verilerini tutar.
 * 		 - default uzunlukları vardır. Default kapasite 16'dır.
 * 		   Eğer default kapasitenin sınırına ulaşılmış ise 
 * 		   kapasite arttırılır. Yük faktörü .75'tir. Bu sınıra
 * 		   ulaşınca kapasite arttırılır. 
 */
		Set<String> setIsimListesi = new HashSet<String>();
		setIsimListesi.add("Ali");
		setIsimListesi.add("Ahmet");
		setIsimListesi.add("Deniz");
		setIsimListesi.add("Bahadır");
		setIsimListesi.add("Ali");
		setIsimListesi.add("Canan");
		setIsimListesi.add("Tekin");
		setIsimListesi.add("Şahin");
		setIsimListesi.add("Deniz");
		setIsimListesi.add("Büşra");		
		System.out.println("*** SET İLE İŞLENEN LİSTE: ***");
		setIsimListesi.forEach(p->System.out.println(p));
		

	}//MAIN ENDS HERE ------

}//CLASS ENDS HERE ------
