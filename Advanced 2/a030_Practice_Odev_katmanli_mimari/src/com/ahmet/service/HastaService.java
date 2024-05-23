package com.ahmet.service;

import java.util.List;

import com.ahmet.repository.HastaRepository;
import com.ahmet.repository.entity.Hasta;

public class HastaService {
	HastaRepository repository = new HastaRepository();
	
	public void save(Hasta hasta) {
		if(hasta.getAdiSoyadi().isBlank()) {
			System.err.println("Eksik bilgi girişi. Lütfen geçerli bir ad-soyad giriniz.");
		}else {
			repository.save(hasta);
		}
	}
	
	public void update(Hasta hasta) {
		repository.update(hasta);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Hasta> findAll() {
		return repository.findAll();
	}
	
	public Hasta findById(Long id) {
		return repository.findById(id);
	}
	
}
