package com.ahmet.mapper;

import com.ahmet.dto.request.KuryeSaveRequestDto;
import com.ahmet.repository.entity.Kurye;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IKuryeMapper {

    IKuryeMapper INSTANCE = Mappers.getMapper(IKuryeMapper.class);

    Kurye toKurye(final KuryeSaveRequestDto dto);

}
