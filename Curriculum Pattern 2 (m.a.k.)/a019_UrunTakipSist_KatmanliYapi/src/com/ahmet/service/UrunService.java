package com.ahmet.service;

import com.ahmet.repository.UrunRepository;
import com.ahmet.repository.entity.Urun;

public class UrunService {
							
	private UrunRepository repository = new UrunRepository();
	
	public void save(String ad, double fiyat, double maliyet, String marka, 
			String model, int adet) {
		if(ad.isBlank()) {
			System.err.println("Ürün adı boş geçilemez!");
		}else {
			repository.save(ad, fiyat, maliyet, marka, model, adet);
		}
	}
	
	public void update(Urun urun) {
		if(urun.ad.isBlank()) {
			System.err.println("Ürün adını silemezsiniz!");
		}
		repository.update(urun);
	}
	
	public void delete(int removeIndex) {
		if(removeIndex<0) {
			System.err.println("İndeks değeri negatif olamaz.");
		}else if(removeIndex>repository.size()) {
			System.out.println("Lütfen geçerli bir aralık girin.");
		}else {
			repository.delete(removeIndex);
		}
	}
	
	public Urun[] findAll() {
		return repository.findAll();
	}
	
	public Urun findByAd(String urunAdi) {
		return repository.findByAd(urunAdi);
	}
	
	public Urun findByIndex(int index) {
		return repository.findByIndex(index);
	}
	
	public int size() {
		return repository.size();
	}
}
