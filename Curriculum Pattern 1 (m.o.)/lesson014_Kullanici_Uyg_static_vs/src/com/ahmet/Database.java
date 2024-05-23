package com.ahmet;

public class Database {
	
	static Kullanici[] kullaniciListesi = new Kullanici[5];
	static int index = 0;

	public static void veriTabaniBaslangicDegerleri() {

		Kullanici kullanici = new Kullanici();
		kullanici.email = "mustafa@gmail.com";
		kullanici.isim = "Mustafa";
		kullanici.password = "123";
		kullanici.id = index+1;		
		kullaniciListesi[index] = kullanici;
		index++;
		
		Kullanici kullanici2 = new Kullanici();
		kullanici2.email = "merve@gmail.com";
		kullanici2.isim = "Merve";
		kullanici2.password = "123";
		kullanici2.id = index+1;
		kullaniciListesi[index] = kullanici2;
		index++;
		
		Kullanici kullanici3 = new Kullanici();
		kullanici3.email = "yasin@gmail.com";
		kullanici3.isim = "Yasin";
		kullanici3.password = "123";
		kullanici3.id = index+1;
		kullaniciListesi[index] = kullanici3;
		index++;
	}
	
	public static void kullaniciEkle(Kullanici kullanici) {
		if(index >= kullaniciListesi.length-2) {
			listeBoyutunuArttir();
		}
		if(index < kullaniciListesi.length) {
			kullaniciListesi[index] = kullanici;
	        index++;
		}		
	}
	
	public static void listeBoyutunuArttir() {
		Kullanici[] temp = new Kullanici[kullaniciListesi.length + 5];
		for(int i=0; i<kullaniciListesi.length; i++) {
			temp[i] = kullaniciListesi[i];
		}
		kullaniciListesi = temp;
	}
	
	public static boolean kullaniciVarMi(String email, String password) {
		
		for(int i=0; i<kullaniciListesi.length; i++) {
			if(kullaniciListesi[i] != null) {
				if((kullaniciListesi[i].email.equalsIgnoreCase(email)) && kullaniciListesi[i].password.equals(password)) {
					System.out.println("Hoşgeldiniz " + kullaniciListesi[i].isim);
					return true;
				}
			}
			
		}
		System.out.println("Giriş başarısız. Kullanıcı adı veya email hatalı.");
		return false;
	}
	

}
