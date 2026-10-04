package com.pet_adoption_center.mapper;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UpdateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(CreateUserRequestDto dto);

    UserResponseDto toResponseDto(User user);

    List<UserResponseDto> toResponseList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateUserFromDto(UpdateUserRequestDto dto, @MappingTarget User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    void partialUpdateUserFromDto(UpdateUserRequestDto dto, @MappingTarget User user);
}
