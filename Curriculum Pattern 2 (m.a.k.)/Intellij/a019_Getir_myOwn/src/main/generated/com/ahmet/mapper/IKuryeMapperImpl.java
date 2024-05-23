package com.ahmet.mapper;

import com.ahmet.dto.request.KuryeSaveRequestDto;
import com.ahmet.repository.entity.Kurye;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T19:14:08+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class IKuryeMapperImpl implements IKuryeMapper {

    @Override
    public Kurye toKurye(KuryeSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Kurye.KuryeBuilder kurye = Kurye.builder();

        kurye.ad( dto.getAd() );
        kurye.soyad( dto.getSoyad() );
        kurye.username( dto.getUsername() );
        kurye.password( dto.getPassword() );
        kurye.adres( dto.getAdres() );
        kurye.telefon( dto.getTelefon() );

        return kurye.build();
    }
}
