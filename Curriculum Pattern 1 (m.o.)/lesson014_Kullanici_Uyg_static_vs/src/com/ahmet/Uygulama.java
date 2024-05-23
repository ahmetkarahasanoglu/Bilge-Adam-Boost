package com.ahmet;

import java.util.Scanner;

public class Uygulama {
	/*
	 * MENÜ'de olacaklar:
	 * 1- Kayıt Ol
	 * 2- Giriş Yap
	 * 3- Kullanıcıları Göster
	 * 0- Çıkış
	 * 
	 * YAPACAKLARIMIZ:
	 * 1- Menümüzü oluşturacağız. (Menümüzü gösteren bir metot)
	 * 2- Seçim yapacağız. (Bir metot, seçim değerini return edecek)
	 * 3- Seçime göre metotları yazacağız.
	 * 3-1 Kayıt ol metodu yazalım; bizden bilgilerimizi alacak, gidecek 
	 *     database sınıfındaki listeye kullanıcıyı ekleyecek.
	 */
	static Scanner sc = new Scanner(System.in); // sc'yi 'statik' olarak Uygulama class'ının içine yazdık.

	public static void main(String[] args) {
		Database.veriTabaniBaslangicDegerleri();
		int secim;
		do {
			menu();	
			secim = secimYap();
			switch(secim) {
				case 1:
					kayitOl();					
					break;
				case 2:
					girisYap();
					break;
				case 3:
					kullanicilariGoster();										
					break;				
				case 0:
					
					break;
				default:
					System.out.println("Invalid selection in the menu!");
			}
		}while(secim != 0);

	}//main ends here
	
	public static void menu() {
		System.out.println("--- MENÜ ---");
		System.out.println("1- Kayıt Ol");
		System.out.println("2- Giriş Yap");
		System.out.println("3- Kullanıcıları Göster");
		System.out.println("0- Çıkış");
	}
	
	public static int secimYap() {		
		System.out.print("Seçiminizi giriniz: ");
		int secim = sc.nextInt();
		sc.nextLine(); //dummy
		return secim;
	}
	
	public static void kayitOl() {
	    Kullanici kullanici = new Kullanici();	        
	    System.out.print("Kullanıcı ismini giriniz: ");
	    kullanici.isim = sc.nextLine();
	    System.out.print("Kullanıcı email adresini giriniz: ");
	    kullanici.email = sc.nextLine();
	    System.out.print("Kullanıcı şifresini giriniz: ");
	    kullanici.password = sc.nextLine();	        
	    kullanici.id = Database.index+1;
	    Database.kullaniciEkle(kullanici);
	}
	
	public static void girisYap() {
		int attempt = 3;
		while(attempt>=1) {
			System.out.print("Email adresinizi giriniz: ");
			String email = sc.nextLine();
			System.out.print("Şifrenizi giriniz: ");
			String password = sc.nextLine();
			if(!Database.kullaniciVarMi(email, password)) { // If no such user in the database (if login is not successful)
				attempt--;
				System.out.println(attempt + " hakkınız kaldı.");
			}else { // If login is successful
				break;
			}
		}
	}
	
	public static void kullanicilariGoster() {		
		for(int i=0; i<Database.kullaniciListesi.length; i++) {
			if(Database.kullaniciListesi[i] != null) {
				System.out.println(Database.kullaniciListesi[i].isim);
				System.out.println(Database.kullaniciListesi[i].email);
				System.out.println(Database.kullaniciListesi[i].password);
				System.out.println(Database.kullaniciListesi[i].id);
				System.out.println("---------------------");
			}
		}
	}

}//class ends here
