package com.placementtracker.service;

import com.placementtracker.dto.LoginRequest;
import com.placementtracker.dto.LoginResponse;
import com.placementtracker.dto.RegisterRequest;

public interface AuthService {
    LoginResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
