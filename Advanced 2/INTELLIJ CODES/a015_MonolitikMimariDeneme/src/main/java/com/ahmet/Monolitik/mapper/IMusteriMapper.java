package com.ahmet.Monolitik.mapper;

import com.ahmet.Monolitik.dto.request.MusteriLoginRequestDto;
import com.ahmet.Monolitik.dto.request.MusteriSaveRequestDto;
import com.ahmet.Monolitik.dto.response.MusteriFindAllResponseDto;
import com.ahmet.Monolitik.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Her framework ve uygulama için nesne yaratma ve işleme
 * mekanizmaları farklıdır. Bu nedenle SpringBoot için Mapper
 * kullanılacak ise anotasyonda model olarak "spring" diye girilmelidir.
 * TargetPolicy -> Eşleştirme yapılacak iki bileşen (Object)
 * birebir birbirine uymayabilir (Dto'dan entity'ye çevirirken
 * veya entity'den Dto'ya çevirirken); bu nedenle eşleştirme
 * yaparken istisna fırlatır. İşte bu noktada eşleşmeyen
 * alanların görmezden gelinmesi için IGNORE kullanmak
 * mantıklı olacaktır.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMusteriMapper {
    /**
     * Bu interface'den bir nesne yaratmak için kullanılır.
     */
    IMusteriMapper INSTANCE = Mappers.getMapper(IMusteriMapper.class);

    /**
     * Buradan itibaren dönüşüm yapmak istediğimiz sınıflara ait
     * metotlar tanımlıyoruz.
     * Burda yazılan metodun adının (fromMusteriSaveRequestDto) ve
     * kullanılan keyword'lerin bir önemi yoktur.
     */
    Musteri fromMusteriSaveRequestDto(final MusteriSaveRequestDto dto);

    MusteriFindAllResponseDto fromMusteri(final Musteri musteri);

}
