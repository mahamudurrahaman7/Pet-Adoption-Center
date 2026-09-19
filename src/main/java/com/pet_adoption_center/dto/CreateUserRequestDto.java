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
public class CreateUserRequestDto {


    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^1[3-9]\\d{8}$", message = "Phone number must be a valid 10-digit number starting with 1 (e.g., 1712345678)")
    private String phoneNumber;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be 0 or greater")
    @Max(value = 150, message = "Age must be realistic")
    private Integer age;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(?i)(MALE|FEMALE|OTHER|NON-BINARY)$", message = "Gender must be MALE, FEMALE, OTHER, or NON-BINARY")
    private String gender;


}