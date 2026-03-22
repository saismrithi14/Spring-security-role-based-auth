package com.example.role_based_auth.service;

import com.example.role_based_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.role_based_auth.entity.User;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        try{
            user.get();
        }
        catch(NoSuchElementException e)
        {
            throw new UsernameNotFoundException("User doesn't exist");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(user.get().getPassword())
                .roles(user.get().getRole())
                .build();
    }
}
