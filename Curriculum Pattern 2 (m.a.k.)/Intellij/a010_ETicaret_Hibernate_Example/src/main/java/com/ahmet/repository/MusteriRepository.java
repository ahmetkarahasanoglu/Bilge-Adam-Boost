package com.ahmet.repository;

import com.ahmet.repository.entity.Musteri;
import com.ahmet.utility.MyFactoryRepository;

public class MusteriRepository extends MyFactoryRepository<Musteri,Long> { // Burdaki 'Musteri' MyFactoryRepository'deki T'dir. 'Long' da ID'dir.


    public MusteriRepository() {
        super(new Musteri());
    }
}
