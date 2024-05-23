package com.ahmet.satis.entity;

import java.util.Date;

public class Satis {
	// "Satış Fişi" sayfası burası..
	public String odemeYontemi;
	public double toplamFiyat; // --> genel toplam.
	public Date tarih;
	public int satisNo;
	public String kasiyer;
	public SatisDetay[] satisDetay; /*  --> Bir satış fişinde, "alınan ürünler"
	kısmındaki 'adet', 'fiyat', 'ürün adı' */ 
	
	

}
