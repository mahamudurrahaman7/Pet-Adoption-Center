package com.pet_adoption_center.service;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(UUID id);
    UserResponseDto createUser(CreateUserRequestDto user);
    UserResponseDto updateUser(User user);
    UserResponseDto partialUpdateUser(User user);
    void deleteUser(UUID id);
}
