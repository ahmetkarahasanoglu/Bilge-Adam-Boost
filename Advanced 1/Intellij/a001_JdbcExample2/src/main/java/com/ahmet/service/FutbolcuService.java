package com.ahmet.service;

import com.ahmet.repository.FutbolcuRepository;
import com.ahmet.repository.entity.Futbolcu;

import java.util.List;
import java.util.Optional;

public class FutbolcuService implements ICrudService<Futbolcu> {

    FutbolcuRepository futbolcuRepository;

    // CONSTRUCTOR:
    public FutbolcuService() {
        this.futbolcuRepository = new FutbolcuRepository();
    }


    @Override
    public void save(Futbolcu futbolcu) {
        futbolcuRepository.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        if(findById(futbolcu.getId()).isPresent()) {
            futbolcuRepository.update(futbolcu);
        }
    }

    @Override
    public void delete(Long id) {
        if(findById(id).isPresent()) {
            futbolcuRepository.delete(id);
        }
    }

    @Override
    public List<Futbolcu> findAll() {
        List<Futbolcu> futbolcuList = futbolcuRepository.findAll();
        if(futbolcuList.isEmpty()) {
            System.out.println("Database'deki tabloda veri bulunmamaktadır.");
        }
        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
        Optional<Futbolcu> futbolcu = futbolcuRepository.findById(id);
        if(futbolcu.isEmpty()) {
            System.out.println("Böyle bir futbolcu bulunamadı.");
        }
        return futbolcu;


    }
}
