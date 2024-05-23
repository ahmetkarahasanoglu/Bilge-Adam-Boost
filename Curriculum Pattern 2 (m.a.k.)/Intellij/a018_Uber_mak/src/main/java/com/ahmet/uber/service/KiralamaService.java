package com.ahmet.uber.service;

import com.ahmet.uber.dto.request.KiralamaSaveRequestDto;
import com.ahmet.uber.mapper.IKiralamaMapper;
import com.ahmet.uber.repository.IKiralamaRepository;
import com.ahmet.uber.repository.entity.Kiralama;
import com.ahmet.uber.repository.entity.KiralamaDurum;
import com.ahmet.uber.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class KiralamaService extends ServiceManager<Kiralama,Long> {

    private final IKiralamaRepository repository;

    public KiralamaService(IKiralamaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Kiralama saveDto(KiralamaSaveRequestDto dto) {
        Kiralama kiralama = IKiralamaMapper.INSTANCE.toKiralama(dto);
        kiralama.setDurum(KiralamaDurum.TALEP);
        return save(kiralama);
    }
}
