package com.ahmet.repository;

import com.ahmet.repository.entity.Urun;

public class UrunRepository {

	Urun[] urunListesi = new Urun[5];
	int count = -1;
	
	public void save(String ad, double fiyat, double maliyet, 
			String marka, String model, int adet) {
		Urun urun = new Urun();
		urun.ad = ad;
		urun.fiyat = fiyat;
		urun.maliyet = maliyet;
		urun.marka = marka;
		urun.model = model;
		urun.adet = adet;
		count++;
		if(count == urunListesi.length) {
			addSave(urun);
		}else {
			urunListesi[count] = urun;
		}
	}
	
	public void update(Urun urun) {
		for(int i=0; i<count+1; i++) {
			if(urunListesi[i].ad.equals(urun.ad)) {
				urunListesi[i] = urun;
			}
		}
	}
	
	public void delete(int indexToRemove) {
		Urun[] temp = new Urun[urunListesi.length-1];
		int indexForTemp = 0;
		for(int i=0; i<urunListesi.length; i++) {
			if(i != indexToRemove) {
				temp[indexForTemp] = urunListesi[i];
				indexForTemp++;
			}			
		}
		urunListesi = temp;
		count--;
	}
	
	public Urun[] findAll() {
		return urunListesi;
	}
	
	public Urun findByAd(String urunAdi) {		
		for(int i=0; i<urunListesi.length; i++) {
			if(urunListesi[i].ad.equalsIgnoreCase(urunAdi)) {				
				return urunListesi[i];			
			}
		}
		return null;
	}
	
	public Urun findByIndex(int index) {
		return urunListesi[index];
	}
	
	private void addSave(Urun urun) { // expands the array '1 position' and saves the new urun.
		Urun[] temp = urunListesi;
		urunListesi = new Urun[count+2];
		for(int i=0; i<temp.length; i++) {
			urunListesi[i] = temp[i];
		}
		urunListesi[count+1] = urun;
	}
	
	public int size() {
		return count + 1;
	}
}
