package com.placementtracker.service.impl;

import com.placementtracker.entity.User;
import com.placementtracker.repository.UserRepository;
import com.placementtracker.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: Implement CRUD methods
}
