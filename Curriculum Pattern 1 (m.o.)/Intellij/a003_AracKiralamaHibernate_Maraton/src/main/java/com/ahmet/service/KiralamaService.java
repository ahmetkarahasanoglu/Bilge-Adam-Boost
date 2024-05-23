package com.ahmet.service;

import com.ahmet.repository.KiralamaRepository;
import com.ahmet.repository.KisiRepository;
import com.ahmet.repository.entity.Kiralama;
import com.ahmet.repository.entity.Kisi;
import com.ahmet.utility.MyFactoryService;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama, Long> {

    public KiralamaService() {
        super(new KiralamaRepository());
    }


}
