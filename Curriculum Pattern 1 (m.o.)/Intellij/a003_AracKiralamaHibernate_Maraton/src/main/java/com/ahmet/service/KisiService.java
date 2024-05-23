package com.ahmet.service;

import com.ahmet.repository.AracRepository;
import com.ahmet.repository.KisiRepository;
import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kisi;
import com.ahmet.utility.MyFactoryService;

public class KisiService extends MyFactoryService<KisiRepository, Kisi, Long> {

    public KisiService() {
        super(new KisiRepository());
    }


}
