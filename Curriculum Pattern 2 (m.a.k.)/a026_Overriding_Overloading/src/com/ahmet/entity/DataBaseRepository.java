package com.ahmet.entity;

public class DataBaseRepository {
/*
 * Uygulama içinde kullanılan ve tanımlanan entity'lerin kayıt
 * edilmesi, daha sonra kullanılması için tanımlanır.
 */
	
	//Parametreye göre farklı constructor metodu çalışacak:
	public void save(Doktor doktor) {
		System.out.println("Doktor kayıt edildi.");
	}
	public void save(Hasta hasta) {
		System.out.println("Hasta kayıt edildi.");
		
	}
	public void save(Randevu randevu) {
		System.out.println("Randevu kayıt edildi.");
	}
}
