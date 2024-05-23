package com.ahmet.repository;

import java.util.List;

import com.ahmet.repository.entity.Kitap;
import static com.ahmet.utility.KitapUtility.*;

public class KitapRepository implements ICrud<Kitap> {

	@Override
	public void save(Kitap t) {
		kitapListesi.add(t);
		
	}

	@Override
	public void update(Kitap t) {
		for(int i=0; i<kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId() == t.getId()) {
				kitapListesi.set(i, t);
				break;				
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		for(int i=0; i<kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId().equals(id)) {
				kitapListesi.remove(i);
				break;
			}
		}
		
	}

	@Override
	public List<Kitap> findAll() {
		return kitapListesi;
	}

	@Override
	public Kitap findById(Long id) {
		for(int i=0; i<kitapListesi.size(); i++) {
			if(kitapListesi.get(i).getId().equals(id)) {
				return kitapListesi.get(i);
			}
		}
		return null;
	}

}