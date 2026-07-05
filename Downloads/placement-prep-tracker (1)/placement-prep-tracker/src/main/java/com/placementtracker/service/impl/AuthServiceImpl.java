package com.placementtracker.service.impl;

import com.placementtracker.dto.LoginRequest;
import com.placementtracker.dto.LoginResponse;
import com.placementtracker.dto.RegisterRequest;
import com.placementtracker.entity.User;
import com.placementtracker.repository.UserRepository;
import com.placementtracker.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse register(RegisterRequest registerRequest) {
        // Check if email already exists
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Create new user
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setName(registerRequest.getName());
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());

        // Save user
        User savedUser = userRepository.save(user);

        // TODO: Generate JWT token
        String token = "jwt-token-placeholder";

        return new LoginResponse(token, savedUser.getEmail(), savedUser.getName());
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Verify password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // TODO: Generate JWT token
        String token = "jwt-token-placeholder";

        return new LoginResponse(token, user.getEmail(), user.getName());
    }
}
