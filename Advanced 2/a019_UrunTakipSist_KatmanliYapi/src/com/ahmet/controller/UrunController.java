package com.ahmet.controller;

import com.ahmet.repository.entity.Urun;
import com.ahmet.service.UrunService;

public class UrunController {
	
	private UrunService service = new UrunService();
	
	public void save(String ad, double fiyat, double maliyet, String marka,
			String model, int adet) {
		service.save(ad, fiyat, maliyet, marka, model, adet);
	}
	
	public void update(Urun urun) {
		service.update(urun);
	}
	
	public void delete(int removeIndex) {
		service.delete(removeIndex);
	}
	
	public Urun[] findAll() {
		return service.findAll();
	}
	
	public Urun findByAd(String urunAdi) {
		return service.findByAd(urunAdi);
	}
	
	public Urun findByIndex(int index) {
		return service.findByIndex(index);
	}
	
	public int size() {
		return service.size();
	}
}
