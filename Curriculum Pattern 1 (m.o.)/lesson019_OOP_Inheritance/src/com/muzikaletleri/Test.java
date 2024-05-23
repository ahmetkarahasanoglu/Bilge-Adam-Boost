package com.muzikaletleri;

public class Test {

	public static void main(String[] args) {
		
		MuzikAleti muzikAleti = new MuzikAleti("Türkiye", "2020", "Zil", "Vurmalı", 2);
		muzikAleti.bilgileriGoster();
		muzikAleti.cal();
		
		TelliMuzikAletleri gitar = new TelliMuzikAletleri();
		gitar.ad = "Gitar";
		gitar.menşei = "Amerika";
		gitar.tur = "Tell çalgı";
		gitar.uretimTarihi = "1956";
		gitar.telSayisi = 6;
		gitar.bilgileriGoster();
		System.out.println("Tel sayısı: " + gitar.telSayisi);
		gitar.cal();
		gitar.telleriDegistir();
		
		Bateri bateri = new Bateri();
		bateri.ad = "Bateri";
		bateri.yuzeyGenisligi = 20;
		
		
	}

}
