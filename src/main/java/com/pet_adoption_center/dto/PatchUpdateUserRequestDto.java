package com.pet_adoption_center.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatchUpdateUserRequestDto {


    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^1[3-9]\\d{8}$", message = "Invalid phone number")
    private String phoneNumber;

    @Min(0) @Max(150)
    private Integer age;

    @Pattern(regexp = "^(?i)(MALE|FEMALE|OTHER|NON-BINARY)$", message = "Invalid gender")
    private String gender;
}
