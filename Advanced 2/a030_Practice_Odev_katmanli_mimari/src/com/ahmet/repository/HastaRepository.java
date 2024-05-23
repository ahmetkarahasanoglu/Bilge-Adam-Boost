package com.ahmet.repository;

import java.util.List;
import com.ahmet.repository.entity.Hasta;
import static com.ahmet.utility.StaticValues.*;

public class HastaRepository implements ICrud<Hasta> {

	@Override
	public void save(Hasta t) {
		hList.add(t);
		
	}

	@Override
	public void update(Hasta t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hasta> findAll() {		
		return hList;
	}

	@Override
	public Hasta findById(Long id) {
		for(int i=0; i<hList.size(); i++) {
			if(hList.get(i).getId() == id) {
				return hList.get(i);
			}
		}
		return null;
	}
	
	
}
