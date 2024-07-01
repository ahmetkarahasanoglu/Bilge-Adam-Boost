package com.ahmet.service;

import com.ahmet.repository.MusteriRepository;
import com.ahmet.repository.entity.Musteri;
import com.ahmet.utility.MyFactoryService;

public class MusteriService extends MyFactoryService<MusteriRepository, Musteri, Long> {

    public MusteriService() {
        super(new MusteriRepository());
    }
}
