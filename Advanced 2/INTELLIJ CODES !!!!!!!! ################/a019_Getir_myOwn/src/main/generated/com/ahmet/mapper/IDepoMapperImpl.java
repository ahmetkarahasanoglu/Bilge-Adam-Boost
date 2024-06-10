package com.ahmet.mapper;

import com.ahmet.dto.request.DepoSaveRequestDto;
import com.ahmet.repository.entity.Depo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T19:14:08+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class IDepoMapperImpl implements IDepoMapper {

    @Override
    public Depo toDepo(DepoSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Depo.DepoBuilder depo = Depo.builder();

        depo.isim( dto.getIsim() );
        depo.adres( dto.getAdres() );

        return depo.build();
    }
}
