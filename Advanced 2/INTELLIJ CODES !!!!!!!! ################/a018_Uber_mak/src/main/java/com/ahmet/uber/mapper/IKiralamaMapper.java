package com.ahmet.uber.mapper;

import com.ahmet.uber.dto.request.KiralamaSaveRequestDto;
import com.ahmet.uber.repository.IKiralamaRepository;
import com.ahmet.uber.repository.entity.Kiralama;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IKiralamaMapper {

    IKiralamaMapper INSTANCE = Mappers.getMapper(IKiralamaMapper.class);

    Kiralama toKiralama(final KiralamaSaveRequestDto dto);

}
