package com.ahmet.repository;

import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kisi;
import com.ahmet.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi, Long> {

    public KisiRepository() {
        super(new Kisi());
    }
}
