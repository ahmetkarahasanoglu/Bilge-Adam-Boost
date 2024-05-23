package com.bilgisayar;

public class Test {
	/*
	 * composition: 'has' relationship (sahiplik ilişkisi)
	 * inheritance: 'is-a' relationship
	 */
	public static void main(String[] args) {
		Islemci islemci = new Islemci();
		Ram ram = new Ram();
		Anakart anakart = new Anakart(islemci, ram); // burada 'islemci' ve 'ram'in new'lenmiş olması lazım (yukarda new'ledik). Yeni nesne oluşturmuş olmamız lazım ki parametre olarak gönderebilelim.
		Klavye klavye = new Klavye();
		Mouse mouse = new Mouse();
		Monitor monitor = new Monitor();
		Kasa kasa = new Kasa();
		HariciDonanim[] hariciDonanims = new HariciDonanim[15];
		hariciDonanims[0] = mouse;
		
		Bilgisayar bilgisayar = new Bilgisayar(anakart, kasa, hariciDonanims);
		System.out.println(bilgisayar.anakart);
		System.out.println(bilgisayar.kasa);
		System.out.println(bilgisayar.hariciDonanimlar[0]);
		System.out.println(bilgisayar.hariciDonanimlar[1]);
		System.out.println(bilgisayar.hariciDonanimlar[2]);
		System.out.println(bilgisayar.anakart.islemci.hiz);
		
		
	}

}
