package com.ahmet.repository;

import com.ahmet.constants.RestApis;

public class MusteriRepository extends Crud {
	
	public final String saveMethod = "SaveAll"; // ilk değer atadık.
	public final String deleteMethod; 	  // İlk değerini aşağıda constructor'da atadık.

	
	
	// Constructor 1 (Default):
	public MusteriRepository() { 
		deleteMethod = "deleteById";  // constructor içinde final değişkene ilk değerini atayabiliyoruz.
	}
	
	// Constructor 2:
	public MusteriRepository(String delete_method) { 
		deleteMethod = delete_method;  // constructor içinde final değişkene ilk değerini atayabiliyoruz.
	}
	
	
	
	public void save() {  // Final metod override edilemez (Crud sınıfından gelen)
//		RestApis.VERSION = "/v2";  // final'ı değiştiremeyiz. Bunu yapamayız.
		String adres = RestApis.FULL_URL_SAVE;
		System.out.println("Müşteri kayıt edildi.");
	}
	
	public void delete() {
		
	}
}
