package com.okulyonetimsistemi;

public interface IOgrenciIsleri {

	Ogrenci ogrenciKaydi();
	boolean ogrenciKaydiSil(String ogrenciNo); // returns boolean
	void bilgilendirmeYap(Ogrenci ogrenci);
	boolean dersKaydiOnayla(Ders ders, Ogrenci ogrenci);
	void ogrencileriListele();
	
}
