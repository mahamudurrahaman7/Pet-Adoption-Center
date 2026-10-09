package com.pet_adoption_center.dto;


import com.pet_adoption_center.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class UpdateUserRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^1[3-9]\\d{8}$", message = "Invalid phone number")
    private String phoneNumber;

    @NotNull(message = "Age is required")
    @Min(0) @Max(150)
    private Integer age;

    @NotNull(message = "Gender is required")
    private Gender gender;
}
