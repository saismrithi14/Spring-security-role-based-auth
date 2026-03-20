package com.example.role_based_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {
    @GetMapping("/public")
    public String publicContent()
    {
        return "This is public content";
    }

    @GetMapping("/admin")
    public String adminContent()
    {
        return "This is admin content";
    }

    @GetMapping("/user")
    public String userContent()
    {
        return "This is user content";
    }
}
