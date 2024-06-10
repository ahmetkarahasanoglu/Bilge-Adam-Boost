package com.ahmet.service;

import com.ahmet.dto.request.MusteriSaveRequestDto;
import com.ahmet.mapper.IMusteriMapper;
import com.ahmet.repository.IMusteriRepository;
import com.ahmet.repository.entity.Musteri;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class MusteriService extends ServiceManager<Musteri,Long> {

    private final IMusteriRepository repository;

    public MusteriService(IMusteriRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Musteri saveDto(MusteriSaveRequestDto dto) {
        return save(IMusteriMapper.INSTANCE.toMusteri(dto));
    }

}
