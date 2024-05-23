package com.ahmet.repository;

import com.ahmet.repository.entity.Urun;
import com.ahmet.utility.MyFactoryRepository;

public class UrunRepository extends MyFactoryRepository<Urun, Long> {

    public UrunRepository() {
        super(new Urun());
    }
}
