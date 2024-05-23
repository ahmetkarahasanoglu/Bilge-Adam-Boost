package com.ahmet.uber.service;

import com.ahmet.uber.dto.request.SoforSaveRequestDto;
import com.ahmet.uber.mapper.ISoforMapper;
import com.ahmet.uber.repository.ISoforRepository;
import com.ahmet.uber.repository.entity.Sofor;
import com.ahmet.uber.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SoforService extends ServiceManager<Sofor,Long> {

    private final ISoforRepository repository;

    public SoforService(ISoforRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Sofor saveDto(SoforSaveRequestDto dto) {
        return save(ISoforMapper.INSTANCE.toSofor(dto));
    }
}
