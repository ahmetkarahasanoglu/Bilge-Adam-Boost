package com.ahmet.repository.entity;

import java.util.Date;

public class Satis {

	public Long id;
/*
 * Satış olgusu mutlaka birisine yapılan satış şeklinde olacak. Bu
 * durumda satışın aidiyeti, müşteri ile ilişkisine bağlı olacak.
 * Yani satış kime yapıldı sorusuna cevap vermeli.
 * 1- Müşteri id tutularak yapılabilir.
 * 2- Müşterinin kendisini tutmak.
 */
	public Long musteriId;  // 1. yöntem (performanslı olan. genelde tercih ettiğimiz)
	public Musteri musteri; // 2. yöntem
/*
 * Satış işleminde ne satılmış -> ürün bilgisinin nasıl tutulacağının
 * belirlenmesi gereklidir.
 */
	public Long urunId;  // 1. yöntem (performanslı olan. genelde tercih ettiğimiz)
	public Urun urun;	  // 2. yöntem
	public int adet;
	public Double birimAlisFiyati;
	public Double birimSatisFiyati;
	public Double toplamFiyat;
	/*
	 * Tarih farklı şekillerde tutulabilir.
	 * 1- String olarak: "01.08.2022"
	 * 2- Date olarak 01-08-2022
	 * 3- Long olarak, zamanın milisaniye cinsinden değeri olarak tutulur.
	 *    '--> 1000 ms -> 1 sn
	 *      ->   60 sn -> 1 dk
	 *    1000*60*60*24 -> 1 gün       
	 */
	public String tarih;
	public Date date;
	public Long timestamp; // tarih ve saati bir arada tutarsınız.
	
	public String odemeYontemi;
	
	
}
