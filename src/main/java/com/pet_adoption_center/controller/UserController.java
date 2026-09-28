package com.pet_adoption_center.controller;


import com.pet_adoption_center.dto.CreateUserRequestDto;
import com.pet_adoption_center.dto.UserResponseDto;
import com.pet_adoption_center.response.ApiResponse;
import com.pet_adoption_center.response.ResponseBuilder;
import com.pet_adoption_center.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;



    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> saveUser(@RequestBody CreateUserRequestDto  createUserRequestDto) {


        return ResponseBuilder.status(HttpStatus.CREATED,
                "New user is created successfully",
                userService.createUser(createUserRequestDto)
                );


    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers(){

        return ResponseBuilder.status(HttpStatus.OK,
                "All users is retrieved successfully",
                userService.getAllUsers()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable UUID id){

        return ResponseBuilder.status(HttpStatus.OK,
                "User is retrieved successfully by id",
                userService.getUserById(id)
        );

    }








}
