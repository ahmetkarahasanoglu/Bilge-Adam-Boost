package com.ahmet.Java6MovieApp.mapper;

import com.ahmet.Java6MovieApp.dto.request.UserRegisterRequestDto;
import com.ahmet.Java6MovieApp.dto.response.UserLoginResponseDto;
import com.ahmet.Java6MovieApp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final UserRegisterRequestDto dto);

    UserLoginResponseDto toUserLoginResponseDto(final User user);

}
