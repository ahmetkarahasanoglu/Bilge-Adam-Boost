package com.ahmet.mapper;

import com.ahmet.dto.request.MusteriSaveRequestDto;
import com.ahmet.repository.entity.Musteri;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T19:14:08+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class IMusteriMapperImpl implements IMusteriMapper {

    @Override
    public Musteri toMusteri(MusteriSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Musteri.MusteriBuilder musteri = Musteri.builder();

        musteri.ad( dto.getAd() );
        musteri.soyad( dto.getSoyad() );
        musteri.username( dto.getUsername() );
        musteri.password( dto.getPassword() );
        musteri.adres( dto.getAdres() );
        musteri.telefon( dto.getTelefon() );

        return musteri.build();
    }
}
