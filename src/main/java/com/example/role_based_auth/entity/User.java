package com.example.role_based_auth.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @NotBlank(message="Name cannot be empty")
    private String username;

    @Size(min=6, message="Number of characters should be atleast 8")
    private String password;


    @NotBlank(message="Role cannot be empty")
    private String role;

}
