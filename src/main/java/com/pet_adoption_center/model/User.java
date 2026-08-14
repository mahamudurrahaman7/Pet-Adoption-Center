package com.pet_adoption_center.model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")

public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;






}
