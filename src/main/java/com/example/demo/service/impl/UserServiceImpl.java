package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void validateLogin(String email, String password)
    {
        userRepository.findByEmail(email)
            .filter(user -> user.getPassword().equals(password))
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
