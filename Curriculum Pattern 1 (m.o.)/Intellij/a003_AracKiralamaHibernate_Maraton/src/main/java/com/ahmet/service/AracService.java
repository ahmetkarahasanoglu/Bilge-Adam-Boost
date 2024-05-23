package com.ahmet.service;

import com.ahmet.repository.AracRepository;
import com.ahmet.repository.entity.Arac;
import com.ahmet.utility.MyFactoryRepository;
import com.ahmet.utility.MyFactoryService;

import java.util.List;

public class AracService extends MyFactoryService<AracRepository, Arac, Long> {

    public AracService() {
        super(new AracRepository());
    }


    public Arac findByMarkaAndModel(String marka, String model) {
        return getRepository().findByMarkaAndModel(marka, model);
    }


    public List<Arac> findAllByDurum(boolean durum) {
        return getRepository().findAllByDurum(durum);
    }


}
