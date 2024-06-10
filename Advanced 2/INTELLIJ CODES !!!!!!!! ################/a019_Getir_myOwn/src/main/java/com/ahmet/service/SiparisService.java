package com.ahmet.service;

import com.ahmet.dto.request.SiparisSaveRequestDto;
import com.ahmet.mapper.ISiparisMapper;
import com.ahmet.repository.ISiparisRepository;
import com.ahmet.repository.entity.Siparis;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SiparisService extends ServiceManager<Siparis,Long> {

    private final ISiparisRepository repository;

    public SiparisService(ISiparisRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Siparis saveDto(SiparisSaveRequestDto dto) {
        return save(ISiparisMapper.INSTANCE.toSiparis(dto));
    }

}
