package com.example.role_based_auth.dto;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message="Name cannot be empty")
    private String username;

    @Size(min=6, message="Password should be at least 8 characters")
    private String password;

    @NotBlank(message="Role cannot be empty")
    private String role;
}
