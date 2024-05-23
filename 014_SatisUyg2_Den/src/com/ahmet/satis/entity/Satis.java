package com.ahmet.satis.entity;

import java.util.Date;

public class Satis {
	// "Satış Fişi" sayfası burası..
	String odemeYontemi;
	double toplamFiyat; // --> genel toplam.
	Date tarih;
	int satisNo;
	String kasiyer;
	SatisDetay[] satisDetay; /*  --> Bir satış fişinde, "alınan ürünler"
	kısmındaki 'adet', 'fiyat', 'ürün adı' */
}
