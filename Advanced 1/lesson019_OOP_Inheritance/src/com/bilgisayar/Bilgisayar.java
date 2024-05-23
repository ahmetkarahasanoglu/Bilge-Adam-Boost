package com.bilgisayar;

public class Bilgisayar {
	
	Anakart anakart;
	Kasa kasa;
	HariciDonanim[] hariciDonanimlar = new HariciDonanim[15];
	
	public Bilgisayar() {		
	}
	
	public Bilgisayar(Anakart anakartt, Kasa kasaa, HariciDonanim[] hariciDonanimlarr) {
		anakart = anakartt;
		kasa = kasaa;
		hariciDonanimlar = hariciDonanimlarr;
	}
	
}
