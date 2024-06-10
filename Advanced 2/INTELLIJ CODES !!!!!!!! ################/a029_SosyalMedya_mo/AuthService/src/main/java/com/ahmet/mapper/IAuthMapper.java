package com.ahmet.mapper;

import com.ahmet.dto.request.RegisterRequestDto;
import com.ahmet.dto.request.NewCreateUserRequestDto;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.rabbitmq.model.ActivationModel;
import com.ahmet.rabbitmq.model.RegisterModel;
import com.ahmet.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(final RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(final Auth auth);

    @Mapping(source = "id", target = "authId")
    NewCreateUserRequestDto toNewCreateUserRequestDto(final Auth auth);

    @Mapping(source = "id", target = "authId")
    RegisterModel toRegisterModel(final Auth auth);

    ActivationModel toActivationModel(final Auth auth);

}
