package com.example.role_based_auth.service;

import com.example.role_based_auth.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    AuthenticationManager authManager;
    public ResponseEntity<String> login(LoginDTO dto){
        try{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
        }
        catch(BadCredentialsException be)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password. Try again");
        }
        catch(UsernameNotFoundException ue){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username. Try again");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong please try again");
        }

        return ResponseEntity.ok("Login successful!!");
    }
}
