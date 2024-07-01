package com.ahmet.service;

import com.ahmet.dto.request.KuryeSaveRequestDto;
import com.ahmet.mapper.IKuryeMapper;
import com.ahmet.repository.IKuryeRepository;
import com.ahmet.repository.entity.Kurye;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KuryeService extends ServiceManager<Kurye,Long> {

    private final IKuryeRepository repository;

    public KuryeService(IKuryeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Kurye saveDto(KuryeSaveRequestDto dto) {
        return save(IKuryeMapper.INSTANCE.toKurye(dto));
    }

}
