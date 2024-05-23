package com.ahmet.nesnesoyutlama;

public class Kedi {
/*
 * Bir sınıf içinde tanımlama yapılabilecek bileşenler:
 * Metot, Değişken, Class, Enum.
 * Bir nesnenin durum bilgisini tutan bileşenlere 'state ' denir.
 * state -> attribute veya property.
 * 
 * Bir kedinin yaşını sınıf içinde nasıl saklarsınız?
 *   Değişkenlerse saklarsınız.
 * Aksiyonları da metotlarla tanımlarsınız.
 */
	int yas;
	String tur;
	String cins;
	String ad;
	String tuyRengi;
	String gozRengi;
	double boy;
	double agirlik;
	int ayaksayisi;
	int kuyrukUzunlugu;
	String desen;
	int hiz;
	boolean aclik;
	boolean uykuDurumu;
	int hareketDurumu;
	/* '--> 0: uyku
	 * 		1: uyanık duruyor (sabit pozisyonda)
	 * 		2: uyanık hareket halinde
	 * 		3: koşuyor
	 * 		4: uyanık yatıyor.
	 */
	

	/*
	 * Varlıkların aksiyonları vardır, bu aksiyonlar class içinde
	 * metotlara denk gelir. Bir sınıfın tüm metotlarına interface
	 * denir.
	 */
	public void uyandir() {
		uykuDurumu = true;
	}
	public void yemekYe() {
		aclik = true;
	}
	public void hizlan() {
		hiz += 5;
		if(hiz > 25) {
			hareketDurumu=3;
		}
	}
}
