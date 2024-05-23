package com.ahmet.controller;

import com.ahmet.repository.entity.Kiralama;
import com.ahmet.service.KiralamaService;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }

    public Kiralama save(Kiralama kiralama) {
        return kiralamaService.save(kiralama);
    }
}
