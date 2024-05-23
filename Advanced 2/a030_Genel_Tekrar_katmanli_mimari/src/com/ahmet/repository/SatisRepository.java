package com.ahmet.repository;

import java.util.List;

import com.ahmet.repository.entity.Satis;
import com.ahmet.utility.StaticValues;

public class SatisRepository implements ICrud<Satis> {

	@Override
	public void save(Satis t) {
		// TODO Auto-generated method stub
//		StaticValues.satisListesi[StaticValues.satisCount] = t;  //  we won't be using this way. We will use ArrayList, as shown below. 
//		StaticValues.satisCount++;
		StaticValues.sList.add(t); // 'add' metodu ile listelere ekleme işlemi yapılır.
		
	}

	@Override
	public void update(Satis t) {
		StaticValues.sList.add(t);  // aslında bu değil de daha farklı komutlar kullanmamız gerek. İlerde görcez bunları.
		
	}

	@Override
	public void delete(Long id) {
		// StaticValues.sList.remove(index);  // index kullanarak silme (bu daha kolaydır, obje vermeye göre)
		// StaticValues.sList.remove(Object); // silinecek objenin kendisini vererek silme. Objeyi veririz, o gider listede o objeyi bulur, siler.
		
		for(int i=0; i<StaticValues.sList.size(); i++) {
			if(StaticValues.sList.get(i).id == id) {
				StaticValues.sList.remove(i);
				break;
			}
		}
	}

	@Override
//	public Satis[] findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public List<Satis> findAll() {		
		return StaticValues.sList;
	}

	@Override
	public Satis findById(Long id) {
		for(int i=0; i<StaticValues.sList.size(); i++) {
			if(StaticValues.sList.get(i).id == id) {
				return StaticValues.sList.get(i);				
			}
		}
		return null;
	}

	

}
