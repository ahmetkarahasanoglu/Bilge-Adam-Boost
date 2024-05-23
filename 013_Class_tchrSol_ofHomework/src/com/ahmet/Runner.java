package com.ahmet;

public class Runner {

	public static void main(String[] args) {
		
		/*
		 * 3 Farklı araç tipi için sınıf yazacağız.
		 * 
		 * 1- Araç sınıfı olacak.(adı, marka, model, özellikleri(özellik sınıfından gelecek), tipi)
		 * 2- Özellik sınıfı (içinde ad ve açıklama) olacak.
		 * 
		 * 	 İçinde belli bir özellik olan araçları listelemek istiyorum (örneğin
		 * kanadı olan araçları listelemek istiyorum --> uçak1, uçak2 mesela).
		 */
		
		Ozellik oz1 = new Ozellik();
		oz1.ad = "Kanat";
		oz1.aciklama = "Uçan araçlar için taşıyıcı bileşendir.";
		
		Ozellik oz2 = new Ozellik();
		oz2.ad = "Tekerlek";
		oz2.aciklama = "Araçların yer ile temasını ve hareketini sağlayan bileşendir.";
		
		Ozellik oz3 = new Ozellik();
		oz3.ad = "Yakıt";
		oz3.aciklama = "Araçların motorları içinde yanarak hareket kabiliyeti veren unsurdur.";
		
		Ozellik oz4 = new Ozellik();
		oz4.ad = "Kaput";
		oz4.aciklama = "Kara taşıtlarının motorlarının üst kısmını kapatan kapaktır.";
		
		
		
		Arac araba = new Arac();
		araba.ad = "Araba";
		araba.marka = "Volkswagen";
		araba.model = "Passat";
		araba.tipi = "Sedan";
		araba.ozellikler = new Ozellik[] {oz2, oz3, oz4};
		
		Arac ucak = new Arac();
		ucak.ad = "Uçak";
		ucak.marka = "Airbus";
		ucak.model = "A380";
		ucak.tipi = "Yolcu uçağı";
		ucak.ozellikler = new Ozellik[] {oz1, oz2, oz3};
		
		Arac bisiklet = new Arac();
		bisiklet.ad = "Bisiklet";
		bisiklet.marka = "Trek";
		bisiklet.model = "EasyRide-500";
		bisiklet.tipi = "Mountain bike";
		bisiklet.ozellikler = new Ozellik[] {oz2};
		
		Arac aracListesi[] = {araba, ucak, bisiklet};		
		
// Kanadı olan araçlar neler?
// 1. bir aracın kanadı var mıdır?:
// 2. bir dizi içinde dönerek bu elemanların kanadının olup olmadığı bulunur.
		String aranan = "yakıt";
		for(int i=0; i<aracListesi.length; i++) {
			for(int j=0; j<aracListesi[i].ozellikler.length; j++) {
				if(aracListesi[i].ozellikler[j].ad.equalsIgnoreCase(aranan)) {
					System.out.println(aracListesi[i].ad + "'ın " + aranan + "'ı vardır.");
				}
			}
		}
		
		
		
		
		

	}//main ends here

}//class ends here
