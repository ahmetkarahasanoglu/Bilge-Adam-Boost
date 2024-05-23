package com.ahmet.mapper;

import com.ahmet.dto.request.DepoSaveRequestDto;
import com.ahmet.repository.entity.Depo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IDepoMapper {

    IDepoMapper INSTANCE = Mappers.getMapper(IDepoMapper.class);

    Depo toDepo(final DepoSaveRequestDto dto);

}
