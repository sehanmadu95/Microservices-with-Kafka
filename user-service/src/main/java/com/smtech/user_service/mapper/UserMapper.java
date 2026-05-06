package com.smtech.user_service.mapper;

import com.smtech.user_service.dto.UserDto;
import com.smtech.user_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}