package com.ahmet.controller;

import com.ahmet.repository.entity.Arac;
import com.ahmet.service.AracService;

import java.util.List;
import java.util.Optional;

public class AracController {

    private AracService aracService;

    public AracController() {
        this.aracService = new AracService();
    }

    public Arac save(String markaInput, String modelInput) {
        return aracService.save(Arac.builder()
                .marka(markaInput)
                .model(modelInput)
                .build()
        );
    }

    public Arac findByMarkaAndModel(String marka, String model) {
        return aracService.findByMarkaAndModel(marka, model);
    }


    public List<Arac> findAllByDurum(boolean durum) {
        return aracService.findAllByDurum(durum);
    }

    public Arac findById(Long aracId) {
        Optional<Arac> arac = aracService.findById(aracId);
        if(arac.isPresent()) {
            return arac.get();
        }else {
            throw new RuntimeException("Araç bulunamadı.");
        }
    }

    public void update(Arac arac) {
        aracService.save(arac);
    }


}
