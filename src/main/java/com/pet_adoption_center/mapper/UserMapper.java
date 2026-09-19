package com.pet_adoption_center.mapper;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UpdateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(CreateUserRequestDto dto);

    UserResponseDto toResponseDto(User user);







}
