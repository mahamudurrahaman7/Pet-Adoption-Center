package com.pet_adoption_center.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private String name;
    private String email;
    private String phoneNumber;

    private Integer age;
    private String gender;


}
