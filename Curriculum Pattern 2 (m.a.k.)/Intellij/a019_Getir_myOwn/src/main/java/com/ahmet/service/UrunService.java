package com.ahmet.service;

import com.ahmet.dto.request.UrunSaveRequestDto;
import com.ahmet.mapper.IUrunMapper;
import com.ahmet.repository.IUrunRepository;
import com.ahmet.repository.entity.Urun;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {

    private final IUrunRepository repository;

    public UrunService(IUrunRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Urun saveDto(UrunSaveRequestDto dto) {
        return save(IUrunMapper.INSTANCE.toUrun(dto));
    }

}
