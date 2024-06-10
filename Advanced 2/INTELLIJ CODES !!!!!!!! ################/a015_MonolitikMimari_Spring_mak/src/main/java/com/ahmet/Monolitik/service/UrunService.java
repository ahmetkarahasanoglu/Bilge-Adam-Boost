package com.ahmet.Monolitik.service;

import com.ahmet.Monolitik.dto.request.UrunSaveRequestDto;
import com.ahmet.Monolitik.mapper.IUrunMapper;
import com.ahmet.Monolitik.repository.IUrunRepository;
import com.ahmet.Monolitik.repository.entity.Urun;
import com.ahmet.Monolitik.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {

    private final IUrunRepository repository;

    public UrunService(IUrunRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void saveDto(UrunSaveRequestDto dto) {
        save(IUrunMapper.INSTANCE.toUrun(dto));
    }
}
