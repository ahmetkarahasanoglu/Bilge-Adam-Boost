package singleRespnsibility;

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
		resimBoyutlandirma.boyutlandirma(instagram, "png");
		System.out.println(instagram.getKucultmeKatsayisi());

	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
