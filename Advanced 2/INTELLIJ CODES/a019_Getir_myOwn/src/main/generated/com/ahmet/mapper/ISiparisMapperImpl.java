package com.ahmet.mapper;

import com.ahmet.dto.request.SiparisSaveRequestDto;
import com.ahmet.repository.entity.Siparis;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T19:14:08+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ISiparisMapperImpl implements ISiparisMapper {

    @Override
    public Siparis toSiparis(SiparisSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Siparis.SiparisBuilder siparis = Siparis.builder();

        return siparis.build();
    }
}
