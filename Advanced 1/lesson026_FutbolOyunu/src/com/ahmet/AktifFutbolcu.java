package com.ahmet;
/*
 * AktifFutbolcu sınıfı, 'Futbolcu' sınıfıyla 'Defans' vs
 * sınırfları arasında bir ara katman olarak oluşturduk (soyut,
 * yani abstract bir sınıf olarak).
 * Ve pasSkoruHesapla() ve pasVer() metotlarını 'Futbolcu'dan
 * 'AktifFutbolcu'ya taşıdık. Böylelikle Futbolcu'dan miras
 * alan Kaleci sınıfı, pas vermeyle ilgili bu metotları
 * miras almamış oldu.
 */
public abstract class AktifFutbolcu extends Futbolcu {

	public AktifFutbolcu(String adSoyad, int formaNo) {
		super(adSoyad, formaNo);
		// TODO Auto-generated constructor stub
	}


	public abstract int pasSkoruHesapla(); // abstract method. (sub-classes have to implement this)
	
	public boolean pasVer() {
		int pasSkoru = pasSkoruHesapla(); // yukarıda tanımladığımız abstract metot sayesinde 'pasSkoruHesapla' metodunu burda kullanabiliyoruz.
		if (pasSkoru > 68) {
			System.out.println("Başarılı pas.");
			return true;
		}else {
			System.out.println("Başarısız pas.");
			return false;
		}
	}
	
	public abstract int golSkoruHesapla(int kurtaris); // abstract method. (sub-classes have to implement this)
	
	public boolean golVurusu(int kurtaris) {
		int golSkoru = golSkoruHesapla(kurtaris); // yukarıda tanımladığımız abstract metot sayesinde 'golSkoruHesapla' metodunu burda kullanabiliyoruz. 
		if(golSkoru > 68) {
			return true;
		}else {
			return false;
		}
	}
	
}
