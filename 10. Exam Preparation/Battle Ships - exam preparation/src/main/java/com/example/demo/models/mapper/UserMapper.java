package com.example.demo.models.mapper;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

@Mapping(target = "username" )
    UserEntity userDtoToUserEntity(UserRegisterDto registerDto);
}
