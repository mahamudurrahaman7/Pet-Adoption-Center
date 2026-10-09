package com.pet_adoption_center.model;

import com.pet_adoption_center.enums.Gender;
import com.pet_adoption_center.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true, name = "phone_number")
    private String phoneNumber;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)          // Database will save String instead of 0,1
    private Role role;


    @Column(name = "is_deleted")
    private boolean isDeleted;


}
