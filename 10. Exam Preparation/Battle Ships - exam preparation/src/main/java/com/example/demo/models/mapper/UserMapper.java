package com.example.demo.models.mapper;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
@Mapping(target = "username" )
    UserEntity userDtoToUserEntity(UserRegisterDto registerDto);
}
