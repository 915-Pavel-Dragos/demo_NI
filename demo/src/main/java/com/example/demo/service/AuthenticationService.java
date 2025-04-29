package com.example.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginUserDTO;
import com.example.demo.model.RegisterUserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDTO input) {
        User user = new User()
                    .setFullName(input.getFullName())
                    .setEmail(input.getEmail())
                    .setPassword(passwordEncoder.encode(input.getPassword()));
        
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(), 
                input.getPassword()
            )
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}