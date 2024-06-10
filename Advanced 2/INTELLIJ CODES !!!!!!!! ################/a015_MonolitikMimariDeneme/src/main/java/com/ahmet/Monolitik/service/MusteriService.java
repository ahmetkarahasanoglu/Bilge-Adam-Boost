package com.ahmet.Monolitik.service;

import com.ahmet.Monolitik.dto.request.MusteriLoginRequestDto;
import com.ahmet.Monolitik.dto.request.MusteriSaveRequestDto;
import com.ahmet.Monolitik.dto.response.MusteriFindAllResponseDto;
import com.ahmet.Monolitik.exception.EErrorType;
import com.ahmet.Monolitik.exception.SatisManagerException;
import com.ahmet.Monolitik.mapper.IMusteriMapper;
import com.ahmet.Monolitik.repository.IMusteriRepository;
import com.ahmet.Monolitik.repository.entity.Musteri;
import com.ahmet.Monolitik.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusteriService extends ServiceManager<Musteri,Long> {

    private final IMusteriRepository repository;

    public MusteriService(IMusteriRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Musteri findByAd(String ad) {
        return repository.findByAd(ad);
    }

    public void saveDto(MusteriSaveRequestDto dto) {
//        if(!dto.getPassword().equals(dto.getRepassword())) {
//            throw new SatisManagerException(EErrorType.PASSWORD_MISMATCH_ERROR);
//        }
//        boolean isAlreadyExist = repository.existsByUsername(dto.getUsername());
//        if(isAlreadyExist) {
//            throw new SatisManagerException(EErrorType.USER_ALREADY_EXISTS);
//        }
        save(IMusteriMapper.INSTANCE.fromMusteriSaveRequestDto(dto)); // Dto'yu müşteriye çevirip kaydediyo.
    }

    public List<MusteriFindAllResponseDto> findAllResponseDtos() { // Tüm müşteri'leri dto'lara çevirip liste olarak dönüyo.
        List<MusteriFindAllResponseDto> result = new ArrayList<>();
        findAll().forEach(x->{
//            result.add(MusteriFindAllResponseDto.builder()
//                    .ad(x.getAd())
//                    .username(x.getUsername())
//                    .img(x.getImg())
//                    .build());
            result.add(IMusteriMapper.INSTANCE.fromMusteri(x));
        });
        return result;
    }

    public Boolean doLogin(MusteriLoginRequestDto dto) {
        Optional<Musteri> musteri = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(musteri.isEmpty()) {
            throw new SatisManagerException(EErrorType.INCORRECT_CREDENTIALS);
        }
        return true;
    }
}
