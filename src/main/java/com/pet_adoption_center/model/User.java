package com.pet_adoption_center.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer phoneNumber;

    private Integer age;
    private String gender;
    private String role;

    @ElementCollection
    @CollectionTable(name = "user_adopted_pets", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "pet_name")
    private List<String> adoptedPet;
}
