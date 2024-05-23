package com.ahmet.service;

import java.util.List;

import com.ahmet.repository.KitapRepository;
import com.ahmet.repository.entity.Kitap;

public class KitapService {
	
	private final KitapRepository kitapRepository; // KitapService'in içinde kitapRepository'yi bir property olarak tanımladık (constructor'da new'leyeceğiz aşağıda).

	// CONSTRUCTOR:
	public KitapService() {
		super();
		this.kitapRepository = new KitapRepository(); // Constructor'da new'ledik. (KitapService'den bir nesne oluşturulduğunda KitapRepository'den de bir nesne oluşturulsun dedik.)
	}
	
	// METHODS: ---------
	public void save(Kitap kitap) {
		kitapRepository.save(kitap);
	}
	
	public void save(String kitapAdi, int sayfaSayisi, String yayinEvi) {
		Kitap kitap = new Kitap();
		kitap.setAd(kitapAdi);
		kitap.setSayfaSayisi(sayfaSayisi);
		kitap.setYayinEvi(yayinEvi);
		kitapRepository.save(kitap);
	}
	
	public void update(Kitap kitap) {
		kitapRepository.update(kitap);
	}
	
	public void delete(Long id) {
		kitapRepository.delete(id);
	}	
	
	public List<Kitap> findAll() {
		return kitapRepository.findAll();
	}
	
	public Kitap findById(Long id) {
		return kitapRepository.findById(id);
	}
	
}
