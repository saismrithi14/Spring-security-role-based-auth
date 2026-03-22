package com.example.role_based_auth.controller;

import com.example.role_based_auth.dto.LoginDTO;
import com.example.role_based_auth.dto.UserDTO;
import com.example.role_based_auth.entity.User;
import com.example.role_based_auth.service.LoginService;
import com.example.role_based_auth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/security")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO dto)
    {
        try{
            userService.registerUser(dto);
            return ResponseEntity.ok("User Registered successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid registration. Please check your credentials before registering");
        }
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto)
    {
        return loginService.login(dto);
    }

}
