package com.ahmet.uber.service;

import com.ahmet.uber.dto.request.AracSaveRequestDto;
import com.ahmet.uber.mapper.IAracMapper;
import com.ahmet.uber.repository.IAracRepository;
import com.ahmet.uber.repository.entity.Arac;
import com.ahmet.uber.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AracService extends ServiceManager<Arac,Long> {

    private final IAracRepository repository;

    public AracService(IAracRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Arac saveDto(AracSaveRequestDto dto) {
        return save(IAracMapper.INSTANCE.toArac(dto));
    }
}
