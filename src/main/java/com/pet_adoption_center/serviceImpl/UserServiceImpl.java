package com.pet_adoption_center.serviceImpl;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UpdateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.mapper.UserMapper;
import com.pet_adoption_center.model.User;
import com.pet_adoption_center.repository.UserRepository;
import com.pet_adoption_center.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static com.pet_adoption_center.enums.Role.USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseList(userRepository.findAllByIsDeletedFalse());
    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        User user = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id: " + id));

        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        User user = userMapper.toEntity(createUserRequestDto);
        user.setRole(USER);
        user.setDeleted(false);

        user = userRepository.save(user);

        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(UUID id, UpdateUserRequestDto dto) {
        User user = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id: " + id));

        userMapper.updateUserFromDto(dto, user);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto partialUpdateUser(UUID id, UpdateUserRequestDto dto) {
        User user = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id: " + id));

        userMapper.partialUpdateUserFromDto(dto, user);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        User user = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id: " + id));

        user.setDeleted(true);
        userRepository.save(user);
    }
}
