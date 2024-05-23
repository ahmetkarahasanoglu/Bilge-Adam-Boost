package com.ahmet.entity;
import java.util.Date;

public class BaglantiYonetimi {
	
	private String baglanti_adresi; // 'private' yaptığımız için sınıfın dışından buraya erişim olmaz. Getter & setter metotlarıyla erişilebilir.

	public String getBaglanti_adresi(String userName) {
		if(userName.equals("Admin")) {
			return baglanti_adresi;
		}else {
			System.err.println("Yetkisiz erişim!");
			return null;
		}
	}

	public void setBaglanti_adresi(String baglanti, String userName, String userRole) {
		if(userName.equals("Admin") || userRole.equals("SuperUser")) {
			System.out.println("kullanıcı adı.....: " + userName);
			System.out.println("Mevcut değer......: " + baglanti_adresi);
			System.out.println("Yeni değer........: " + baglanti);
			System.out.println("İşlem tarihi......: " + (new Date()));
			
			baglanti_adresi = baglanti;
		}else {
			System.err.println("Yetkisiz işlem denemesi!");
		}
	}
}
