package com.pet_adoption_center.service;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.PatchUpdateUserRequestDto;
import com.pet_adoption_center.dto.UpdateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(UUID id);
    UserResponseDto createUser(CreateUserRequestDto user);
    UserResponseDto updateUser(UUID id, UpdateUserRequestDto dto);
    UserResponseDto partialUpdateUser(UUID id, PatchUpdateUserRequestDto dto);
    void deleteUser(UUID id);
}
