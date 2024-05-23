package com.ahmet.mapper;

import com.ahmet.dto.request.SiparisSaveRequestDto;
import com.ahmet.repository.entity.Siparis;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ISiparisMapper {

    ISiparisMapper INSTANCE = Mappers.getMapper(ISiparisMapper.class);

    Siparis toSiparis(final SiparisSaveRequestDto dto);

}
