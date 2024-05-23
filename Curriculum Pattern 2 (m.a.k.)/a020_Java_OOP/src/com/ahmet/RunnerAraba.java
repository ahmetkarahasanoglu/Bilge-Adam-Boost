package com.ahmet;

import com.ahmet.entity.Araba;

public class RunnerAraba {
	
	public static void main(String[] args) {
		Araba araba = new Araba();	
		System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		araba.motoruCalistir();
		for(int i=0; i<30; i++) {
			araba.hizlan();
			System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		}
		araba.vitesArttir();
		for(int i=0; i<30; i++) {
			araba.hizlan();
			System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		}
		araba.vitesArttir();
		for(int i=0; i<30; i++) {
			araba.hizlan();
			System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		}
		araba.vitesArttir();
		for(int i=0; i<30; i++) {
			araba.hizlan();
			System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		}
		araba.vitesArttir();
		for(int i=0; i<30; i++) {
			araba.hizlan();
			System.out.println("Arabanın mevcut hızı: " + araba.hiz);
		}
		
		
		/*
		 * Arabamızı hızlandıracağız:
		 * 1- her adımda 5 km/h hızlansın.
		 * 2- araba çalışmıyor ise (hızlan komutu verdiğim anda), uyarı versin "arabayı çalıştır" desin.
		 * 3- vites default 1 olsun.
		 * 4- v1= 0-100, v2=100-180, v3=180-220, v4=220-300, v5=300+
		 * 5- eğer araç 100'ü geçerse vites değişmemişse uyarı versin ve hızı artmasın.
		 * 6- fren yaptığımda dursun.
		 */
		
		
		
	}//main ends here
	
//	public static void motoruCalistir() {
//		araba.motorCalisiyorMu = true;
//	}
//	

//	
//	public static void vitesGuncelle() {
//		int hiz = araba.hiz;
//		if(hiz>=0 && hiz<100) {
//			araba.vites = 1;
//		}else if(hiz>=100 && hiz<180) {
//			araba.vites = 2;
//		}else if(hiz>=180 && hiz<220) {
//			araba.vites = 3;
//		}else if(hiz>=220 && hiz<300) {
//			araba.vites = 4;
//		}else if(hiz>=300) {
//			araba.vites = 5;
//		}
//	}
//	
//	public static void frenYap() {
//		araba.hiz = 0;
//	}
	

}//class ends here
