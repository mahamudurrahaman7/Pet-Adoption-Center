package com.pet_adoption_center.service;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    UserResponseDto createUser(CreateUserRequestDto user);
    UserResponseDto updateUser(User user);
    UserResponseDto partialUpdateUser(User user);
    void deleteUser(Long id);
}
