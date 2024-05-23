package com.ahmet.repository;

import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kiralama;
import com.ahmet.utility.MyFactoryRepository;

public class KiralamaRepository extends MyFactoryRepository<Kiralama, Long> {

    public KiralamaRepository() {
        super(new Kiralama());
    }
}
