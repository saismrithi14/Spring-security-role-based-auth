package com.example.role_based_auth.service;

import com.example.role_based_auth.dto.UserDTO;
import com.example.role_based_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.role_based_auth.entity.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserDTO dto)
    {
        User user = new User();
        user.setUsername(dto.getUsername());

        user.setRole(dto.getRole());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return Collections.unmodifiableList(userRepository.findAll());
    }
}
