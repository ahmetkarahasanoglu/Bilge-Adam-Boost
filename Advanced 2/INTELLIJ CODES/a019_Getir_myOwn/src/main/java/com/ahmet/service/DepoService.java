package com.ahmet.service;

import com.ahmet.dto.request.DepoSaveRequestDto;
import com.ahmet.mapper.IDepoMapper;
import com.ahmet.repository.IDepoRepository;
import com.ahmet.repository.entity.Depo;
import com.ahmet.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepoService extends ServiceManager<Depo,Long> {

    private final IDepoRepository repository;


    public DepoService(IDepoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Depo saveDto(DepoSaveRequestDto dto) {
        return save(IDepoMapper.INSTANCE.toDepo(dto));
    }
}
