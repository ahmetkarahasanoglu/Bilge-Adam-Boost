package com.ahmet.list.ArrayListOrnek;

public class Ogrenci {

	String uuid;
	String ad;
	String soyad;
	DersNotlari notlar; // not: DersNotu sınıfının içinde her bir ders için LİSTE oluşturmuştuk (Yani matematik notları, türkçe notları vs.).
	
	public Ogrenci() {
		notlar = new DersNotlari();
	}
	
}
