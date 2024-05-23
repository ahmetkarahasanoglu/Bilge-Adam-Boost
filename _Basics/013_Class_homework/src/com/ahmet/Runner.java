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
		Ozellik tasitOzellikUcak = new Ozellik();
		tasitOzellikUcak.ad = "Uçak";
		tasitOzellikUcak.aciklama = "Sabit kanatlı hava taşıma aracı";
		
		Arac ucak = new Arac();
		ucak.kanadiVarMi = true;
		ucak.modelYili = 2020;
		ucak.marka = "Boeing";
		ucak.model = "747";
		ucak.ozellik = tasitOzellikUcak;
		//--------------
		
		Ozellik tasitOzellikHelikopter = new Ozellik();
		tasitOzellikHelikopter.ad = "Helikopter";
		tasitOzellikHelikopter.aciklama = "Hareketli kanatlı hava taşıma aracı";
		
		Arac helikopter = new Arac();
		helikopter.kanadiVarMi = true;
		helikopter.modelYili = 2018;
		helikopter.marka = "Sea bird";
		helikopter.model = "650-C";
		helikopter.ozellik = tasitOzellikHelikopter;
		//--------------
		
		Ozellik tasitOzellikAraba = new Ozellik();
		tasitOzellikAraba.ad = "Araba";
		tasitOzellikAraba.aciklama = "Dört tekerlekli kara aracı";
		
		Arac araba = new Arac();
		araba.kanadiVarMi = false;
		araba.modelYili = 2023;
		araba.marka = "Mercedes-Benz";
		araba.model = "E200 Kompressör";
		araba.ozellik = tasitOzellikAraba;
		
		// ############
		
		Arac[] araclar = {ucak, helikopter, araba};
		
		 for (Arac arac : araclar) {
	            if (arac.kanadiVarMi) {
	                System.out.println("Arac Marka: " + arac.marka);
	                System.out.println("Arac Model: " + arac.model);
	                System.out.println("Arac Ozellik Adı: " + arac.ozellik.ad);
	                System.out.println("Arac Ozellik Aciklaması: " + arac.ozellik.aciklama);
	                System.out.println("--------------------");
	            }
	        }
		
		
	}//main ends here

}//class ends here
