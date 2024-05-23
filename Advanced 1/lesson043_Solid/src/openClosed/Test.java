package openClosed;

import openClosed.ResimBoyutlandirma;
import utility.Kullanici;

public class Test {

	public static void main(String[] args) {
		
//		Facebook facebook = new Facebook();
//		Instagram instagram = new Instagram();
//		Kullanici kullanici = new Kullanici("Mustafa", "mustafa@gmail.com");
//		facebook.emailGonder(kullanici);
//		instagram.emailGonder(kullanici);
		
		ResimBoyutlandirma resimBoyutlandirma = new ResimBoyutlandirma();
		Instagram instagram = new Instagram();
		Facebook facebook = new Facebook();
//		resimBoyutlandirma.boyutlandirma2(instagram, "png");
//		resimBoyutlandirma.boyutlandirma2(facebook, "png");
//		System.out.println("instagram --> " + instagram.getKucultmeKatsayisi());
//		System.out.println("facebook --> " + facebook.getKucultmeKatsayisi());

		// Open/Closed Yapısı Sağlandıktan Sonraki Test:
		SosyalMedya sosyalMedya1 = new Instagram(); // Polimorfizm
		SosyalMedya sosyalMedya2 = new Facebook();
		SosyalMedya sosyalMedya3 = new Whatsapp();
		
		resimBoyutlandirma.boyutlandirma3(sosyalMedya1, "png");
		resimBoyutlandirma.boyutlandirma3(sosyalMedya2, "png");
		resimBoyutlandirma.boyutlandirma3(sosyalMedya3, "png");
		
		System.out.println("instagram --> " + sosyalMedya1.getKucultmeKatsayisi());
		System.out.println("facebook --> " + sosyalMedya2.getKucultmeKatsayisi());
		System.out.println("whatsapp --> " + sosyalMedya3.getKucultmeKatsayisi());
		
	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
