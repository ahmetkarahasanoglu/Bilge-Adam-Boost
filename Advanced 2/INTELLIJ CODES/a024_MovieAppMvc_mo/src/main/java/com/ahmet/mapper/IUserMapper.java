package com.ahmet.mapper;

import com.ahmet.dto.request.RegisterRequestDto;
import com.ahmet.dto.response.LoginResponseDto;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(final User user);

    LoginResponseDto toLoginResponseDto(final User user);


}
