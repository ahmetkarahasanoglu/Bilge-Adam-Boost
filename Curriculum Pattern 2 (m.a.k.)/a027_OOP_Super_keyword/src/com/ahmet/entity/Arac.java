package com.ahmet.entity;

import java.util.UUID;

public class Arac {

	String uuid;
	String yakit;
	int yolcu;
	int hiz;
	int otv;
	
	// Default Constructor:
	public Arac() {
		uuid = UUID.randomUUID().toString(); // when an 'arac' object is created, it will automatically have a uuid.
		System.out.println("Araç constructor'ı çalıştı (parametresiz default constructor'ı).");
	}
	
	// Constructor With Parameter:
	public Arac(double fiyat) {
		this(); // !!! calls the default constructor of this class (the constructor without parameter)
		System.out.println("Araç parametreli constructor'ı çalıştı.");
		if(fiyat < 350_000) {
			otv = (int)(fiyat * 1.4);
		}else if(fiyat < 850_000) {
			otv = (int)(fiyat * 2.2);
		}else {
			otv = (int)(fiyat * 3.6);
		}
	}

	@Override
	public String toString() {
		return "Arac [uuid=" + uuid + ", yakit=" + yakit + ", yolcu=" + yolcu + ", hiz=" + hiz + ", otv=" + otv + "]";
	}
	
	
	
}
