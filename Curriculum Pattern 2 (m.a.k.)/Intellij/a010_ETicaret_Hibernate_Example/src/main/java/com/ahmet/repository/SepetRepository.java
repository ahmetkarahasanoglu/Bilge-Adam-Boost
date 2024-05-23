package com.ahmet.repository;

import com.ahmet.repository.entity.Sepet;
import com.ahmet.utility.MyFactoryRepository;

public class SepetRepository extends MyFactoryRepository<Sepet, Long> {

    public SepetRepository() {
        super(new Sepet());
    }
}
