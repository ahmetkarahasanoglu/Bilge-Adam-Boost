package com.ahmet.mapper;

import com.ahmet.dto.request.MusteriSaveRequestDto;
import com.ahmet.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IMusteriMapper {

    IMusteriMapper INSTANCE = Mappers.getMapper(IMusteriMapper.class);

    Musteri toMusteri(final MusteriSaveRequestDto dto);

}
