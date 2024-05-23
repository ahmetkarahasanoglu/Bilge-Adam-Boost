package com.ahmet.repository;

import java.util.List;
import com.ahmet.repository.entity.Musteri;
import static com.ahmet.utility.StaticValues.*;  // A shortcut that enables us to write the static things like mList, uList, sList (which is in StaticValues file) without writing 'StaticValues.something' each time. We can simply write 'mList'.



/*
 * MusteriRepository -> çırak (depo ile mutfak arasında bağlantı
 * kuruyor) [depo: repository. mutfak: service.
 * 
 * Not: Verilerimizin (array'lerimizin) tutulduğu yer: StaticValues (utility package'da)
 * 
 * Bu class'lar; depodakilerle (repository), mutfak (service) 
 * arasında bağlantı kuran unsurlardır. Bu unsurlar:
 * '--> MusteriRepository, SatisRepository, UrunRepository
 * 
 * Bu belgede müşterilerin kaydedilmesi, güncellenmesi
 * komutlarını vs. yazacaz; müşterilerin tutulduğu 
 * yer: utility -> StaticValues
 * 
 */
public class MusteriRepository implements ICrud<Musteri> {

	@Override
	public void save(Musteri t) {
		mList.add(t);		// by writing 'mList', we actually used 'StaticValues.mList' (we had imported 'StaticValues.*' at the top of the page here)
		
	}

	@Override
	public void update(Musteri t) {
		for(int i=0; i<mList.size(); i++) {
			if(mList.get(i).getId() == t.getId()) {
//				StaticValues.mList.get(i).setAd(t.getAd()); // Not Practical
				mList.remove(i);  // my way; I wrote this
				mList.add(i, t);  // my way; I wrote this
				break;
				
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		for(int i=0; i<mList.size(); i++) {
			if(mList.get(i).getId() == id) {
				mList.remove(i);
				break;
			}
		}
		
	}

	@Override
	public List<Musteri> findAll() {
		return mList;		
	}

	@Override
	public Musteri findById(Long id) {
		for(int i=0; i<mList.size(); i++) {
			if(mList.get(i).getId() == id) {
				return mList.get(i);
			}
		}
		return null;
	}

	
	

}
