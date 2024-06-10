package com.ahmet.uber.mapper;

import com.ahmet.uber.dto.request.AracSaveRequestDto;
import com.ahmet.uber.repository.entity.Arac;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAracMapper {

    IAracMapper INSTANCE = Mappers.getMapper(IAracMapper.class);

    Arac toArac(final AracSaveRequestDto dto);

}
