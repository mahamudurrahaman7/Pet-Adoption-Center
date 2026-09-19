package com.pet_adoption_center.serviceImpl;

import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.mapper.UserMapper;
import com.pet_adoption_center.model.User;
import com.pet_adoption_center.service.UserService;
import com.pet_adoption_center.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.pet_adoption_center.enums.Role.USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {

        System.out.println(createUserRequestDto.getAge());
        System.out.println(createUserRequestDto.getName());

        User user = userMapper.toEntity(createUserRequestDto);
        user.setRole(USER);

        System.out.println(user.getAge());
        System.out.println(user.getName());



        user = userRepository.save(user);

        return userMapper.toResponseDto(user);


    }

    @Override
    public UserResponseDto updateUser(User user) {
        return null;
    }

    @Override
    public UserResponseDto partialUpdateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
