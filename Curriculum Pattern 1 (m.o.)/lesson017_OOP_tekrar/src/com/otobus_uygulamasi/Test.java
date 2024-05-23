package com.otobus_uygulamasi;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		Otobus otobus = new Otobus();
		otobus.guzergah = new Guzergah();
		otobus.guzergah.hatNo = 400;
		otobus.kapiSayisi = 3;
		otobus.yolcuKapasitesi = 100;
		otobus.klimaVarMi = true;
		otobus.renk = "kırmızı";
		System.out.println(otobus.yolcuSayisi);
		otobus.yolcuAl(5);
		System.out.println(otobus.yolcuSayisi);
		
		
		Durak durak1 = new Durak();
		durak1.durakNo = 12256;
		durak1.durakIsmi = "Ulus";
		durak1.konum = "Ankara/Ulus";
		durak1.otobusListesi = new Otobus[8];
		Durak durak2 = new Durak();
		durak2.durakNo = 12260;
		durak2.durakIsmi = "Keçiören";
		durak2.konum = "Ankara/Keçiören";
		
		// Guzergah guzergah = new Guzergah() // info: bu satır aşağıdakiyle aynı işi yapıyor.
		otobus.guzergah = new Guzergah();
		otobus.guzergah.durakListesi = new Durak[2];
		otobus.guzergah.durakListesi[0] = durak1;
		otobus.guzergah.durakListesi[1] = durak2;
		otobus.guzergah.hatNo = 420;
//---------------- Üsttekiyle alttakiler farklı uygulama yöntemleri. ama aynı yere çıkıyo.		
		Otobus otobus2 = new Otobus();//Oluşturma
		otobus2.yolcuKapasitesi = 140;
		otobus2.kapiSayisi = 5;
		otobus2.korukluMu = true;
		
		Durak durak3 = new Durak(); // Oluşturma
		durak3.durakNo = 13560;
		durak3.durakIsmi = "Yenimahalle";
		durak3.konum = "Ankara/Yenimahalle";
		Durak durak4 = new Durak(); // Oluşturma
		durak4.durakNo = 12254;
		durak4.durakIsmi = "Kızılay";
		durak4.konum = "Ankara/Kızılay";
		Guzergah guzergah = new Guzergah(); // Oluşturma
		guzergah.durakListesi = new Durak[3]; // (bu bir dizi olduğu için, içine bir şey koymadan önce Boyutunun belirlenmesi gerekiyor. O yüzden new'leyip boyutunu belirledik).
		guzergah.hatNo = 114;		
		guzergah.durakListesi[0] = durak3; // Atama
		guzergah.durakListesi[1] = durak1; // (aynı durağı farklı otobüslerin güzergahlarında kullanabiliyoruz.)
		guzergah.durakListesi[2] = durak4;
		System.out.println(otobus2.guzergah);
		otobus2.guzergah = guzergah; 	// Atama
		System.out.println(otobus2.guzergah);
		System.out.println();
		
		durak1.otobusListesi = new Otobus[2];
		durak1.otobusListesi[0] = otobus;
		durak1.otobusListesi[1] = otobus2;		
		
		System.out.println("Otobus 1'in durak listesi:");
		for(int i=0; i<otobus.guzergah.durakListesi.length; i++) {
			System.out.println(otobus.guzergah.durakListesi[i].durakNo + ", ");
		}
		System.out.println();
		System.out.println("Otobus 2'nin durak listesi:");
		for(int i=0; i<otobus2.guzergah.durakListesi.length; i++) {
			System.out.println(otobus2.guzergah.durakListesi[i].durakNo + ", ");
		}
		
		System.out.println();
		System.out.println(durak1.otobusListesi[1].kapiSayisi);
		
		System.out.println();
		for(int i=0; i<durak1.otobusListesi.length; i++) {
			if(durak1.otobusListesi[i] != null) {
				System.out.println(durak1.otobusListesi[i].yolcuKapasitesi);
			}
		}
		
	}//main ends here
	

}//class ends here
