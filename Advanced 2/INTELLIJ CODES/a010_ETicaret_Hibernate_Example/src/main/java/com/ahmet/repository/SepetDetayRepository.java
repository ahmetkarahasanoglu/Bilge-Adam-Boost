package com.ahmet.repository;

import com.ahmet.repository.entity.SepetDetay;
import com.ahmet.utility.MyFactoryRepository;

public class SepetDetayRepository extends MyFactoryRepository<SepetDetay, Long> {

    public SepetDetayRepository() {
        super(new SepetDetay());
    }
}
