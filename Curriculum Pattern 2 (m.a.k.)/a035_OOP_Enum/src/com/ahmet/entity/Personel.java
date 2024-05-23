package com.ahmet.entity;

import java.util.UUID;

import com.ahmet.utility.Unvan;

public class Personel {

	public String uuid;
	public String ad;
	public String adres;
	public String telefon;
	public Unvan unvan;  // enum değişkeni bu şekilde tanımlıyoruz sınıfımızda.
	public State state;
	public Cinsiyet cinsiyet;
	public Yetki yetki;
	
	// CONSTRUCTOR:
	/**
	 * 
	 * @param ad
	 * @param adres
	 * @param telefon
	 * @param unvan -> onlarca ünvan olabilir, yönetmek zordur.
	 * @param state -> kaydın durumunu bildirir; aktif, pasif, silinmiş. Örneğin: 0- silinmiş, 1- aktif ... 
	 * @param cinsiyet -> E/K  - Erkek/Kadın
	 * @param yetki -> Admin - User - SuperUser - Guest
	 */
	public Personel(String ad, String adres, String telefon, Unvan unvan, State state, Cinsiyet cinsiyet, Yetki yetki) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.ad = ad;
		this.adres = adres;
		this.telefon = telefon;
		this.unvan = unvan;
		this.state = state;
		this.cinsiyet = cinsiyet;
		this.yetki = yetki;
	}
	
	
	
	
}
