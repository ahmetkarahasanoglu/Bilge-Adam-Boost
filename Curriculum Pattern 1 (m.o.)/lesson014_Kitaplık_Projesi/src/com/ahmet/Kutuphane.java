package com.ahmet;

public class Kutuphane {
	static int boyut;
	static int index;	
	Kitap[] kitapListesi;
	Yazar[] yazarListesi;
	static int yazarIndex = 0;
	
	
	public Yazar yazarKontrol(String isim) {
		Yazar yeniYazar = new Yazar();
		if(yazarListesi==null) {
			yazarListesi = new Yazar[50];			
			yeniYazar.isim = isim;
			yazarListesi[yazarIndex] = yeniYazar;
			yazarIndex++;			
		}else {
			boolean isAuthorAvailable = false;
			for(int i=0; i<yazarListesi.length; i++) {
				if(yazarListesi[i] != null) {
					if(yazarListesi[i].isim.equals(isim)) {					
						isAuthorAvailable = true;
						System.out.println("Yazar database'de kayıtlıdır.");						
						return yazarListesi[i];
					}
				}
			}
			if(isAuthorAvailable == false) {
				yeniYazar.isim = isim;
				yazarListesi[yazarIndex] = yeniYazar;
				yazarIndex++;				
			}
			
		}
		return yeniYazar;
	}
}
	
//	// ------- MY TRIAL -------
//	public Yazar yazarKontrol(String isim) {
//		Yazar yeniYazar = new Yazar();
//		if(yazarListesi==null) {
//			yazarListesi = new Yazar[50];			
//			yeniYazar.isim = isim;
//			yazarListesi[yazarIndex] = yeniYazar;
//			yazarIndex++;
//			return yeniYazar;
//		}else {
////			boolean isAuthorAvailable = false;
//			for(int i=0; i<yazarListesi.length; i++) {			
//				if(yazarListesi[i] != null) {
//					if(yazarListesi[i].isim.equals(isim)) {
//						System.out.println("Yazar database'de kayıtlıdır.");
////						isAuthorAvailable = true;
//							return yazarListesi[i];
//					}
//				}
//			}
//			yeniYazar.isim = isim;
//			yazarListesi[yazarIndex] = yeniYazar;
//			yazarIndex++;
//			return yeniYazar;
//		}
//	}
//}