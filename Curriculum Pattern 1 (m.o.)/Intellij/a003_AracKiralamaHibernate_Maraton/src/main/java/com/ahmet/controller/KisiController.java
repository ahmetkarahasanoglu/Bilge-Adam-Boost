package com.ahmet.controller;

import com.ahmet.repository.entity.Arac;
import com.ahmet.repository.entity.Kisi;
import com.ahmet.service.KisiService;

import java.util.Optional;

public class KisiController {

    KisiService kisiService;

    public KisiController() {
        kisiService = new KisiService();
    }

    public Kisi save(String name, String username, String password) {
        return kisiService.save(Kisi.builder()
                .name(name)
                .username(username)
                .password(password)
                .build()
        );
    }

    public Kisi findById(Long userId) {
        Optional<Kisi> kisi = kisiService.findById(userId);
        if(kisi.isPresent()) {
            return kisi.get();
        }else {
            throw new RuntimeException("Kişi bulunamadı.");
        }
    }
}
