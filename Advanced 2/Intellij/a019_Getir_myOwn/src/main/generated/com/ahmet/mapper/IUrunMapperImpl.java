package com.ahmet.mapper;

import com.ahmet.dto.request.UrunSaveRequestDto;
import com.ahmet.repository.entity.Urun;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T19:14:07+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class IUrunMapperImpl implements IUrunMapper {

    @Override
    public Urun toUrun(UrunSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Urun.UrunBuilder urun = Urun.builder();

        urun.marka( dto.getMarka() );
        urun.isim( dto.getIsim() );
        urun.skt( dto.getSkt() );
        urun.barkod( dto.getBarkod() );

        return urun.build();
    }
}
