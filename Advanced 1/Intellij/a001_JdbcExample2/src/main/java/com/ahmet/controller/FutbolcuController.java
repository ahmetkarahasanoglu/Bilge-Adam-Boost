package com.ahmet.controller;

import com.ahmet.repository.ICrud;
import com.ahmet.repository.entity.Futbolcu;
import com.ahmet.service.FutbolcuService;

import java.util.List;
import java.util.Optional;

public class FutbolcuController implements ICrud<Futbolcu> {

    FutbolcuService futbolcuService = new FutbolcuService();

    // CONSTRUCTOR:
    public FutbolcuController() {
        this.futbolcuService = new FutbolcuService();
    }


    @Override
    public void save(Futbolcu futbolcu) {
        futbolcuService.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        futbolcuService.update(futbolcu);
    }

    @Override
    public void delete(Long id) {
        futbolcuService.delete(id);
    }

    @Override
    public List<Futbolcu> findAll() {
        return futbolcuService.findAll();
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
        return futbolcuService.findById(id);
    }
}
