package com.ahmet.service;

import java.util.List;
import com.ahmet.repository.MusteriRepository;
import com.ahmet.repository.entity.Musteri;

/*
 * - Servis katmanı, bir restorant'taki aşçıdır. Malzemeleri karıştırıp ürün
 * ortaya çıkarır.
 * '--> Ne iş yapacaksak, servis katmanında yazarız.
 */
public class MusteriService {	
	MusteriRepository repository = new MusteriRepository();
	
	public void save(Musteri musteri) {
		if(musteri.getAd().isEmpty()) {
			System.err.println("Eksik bilgi girişi. Lütfen geçerli bir ad giriniz.");
		}else {			
			repository.save(musteri);
		}	
	}
	
	public void update(Musteri musteri) {		
		repository.update(musteri);
	}
	
	public void delete(Long id) {		
		repository.delete(id);
	}
	
	public List<Musteri> findAll() {		
		return repository.findAll();
	}
	
	public Musteri findById(Long id) {		
		return repository.findById(id);
	}

}
