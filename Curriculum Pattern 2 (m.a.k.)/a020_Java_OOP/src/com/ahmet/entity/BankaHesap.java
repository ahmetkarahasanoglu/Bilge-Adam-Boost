package com.ahmet.entity;

public class BankaHesap {
	public int id;
	public String hesapno;
	public String iban;
	public double miktar;
	public int musteri_id;
	public Musteri musteri; // (2. yöntemi uygularsak bu satırı yazarız [çoklu olan tarafta tekli olan data'nın tüm bilgilerinin tutulması].
}
