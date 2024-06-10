package com.ahmet.uber.service;

import com.ahmet.uber.dto.request.MusteriSaveRequestDto;
import com.ahmet.uber.mapper.IMusteriMapper;
import com.ahmet.uber.repository.IMusteriRepository;
import com.ahmet.uber.repository.entity.Musteri;
import com.ahmet.uber.utility.ServiceManager;
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
