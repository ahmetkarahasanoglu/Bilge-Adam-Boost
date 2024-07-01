package com.ahmet.mapper;

import com.ahmet.dto.request.NewCreateUserRequestDto;
import com.ahmet.dto.request.UpdateEmailOrUsernameRequestDto;
import com.ahmet.dto.request.UserProfileUpdateRequestDto;
import com.ahmet.rabbitmq.model.RegisterElasticModel;
import com.ahmet.rabbitmq.model.RegisterModel;
import com.ahmet.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);


    UserProfile toUserProfile(final NewCreateUserRequestDto dto);

    UserProfile toUserProfile(final RegisterModel model);

    UpdateEmailOrUsernameRequestDto toUpdateEmailOrUsernameRequestDto(final UserProfileUpdateRequestDto dto);

    RegisterElasticModel toRegisterElasticModel(final UserProfile userProfile);

}
