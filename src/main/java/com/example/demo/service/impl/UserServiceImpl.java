package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user)
    {
        if(userRepository == null)
        {
            throw new NullPointerException("UserRepository is null");
        }

        if(user.getEmail() != null && userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new BadRequestException("Email already used");
        }

        if(user.getPassword() != null)
        {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        if(user.getRole() == null)
        {
            user.setRole(User.Role.CUSTOMER.name());
        }

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id)
    {
        if(userRepository == null)
        {
            throw new NullPointerException("UserRepository is null");
        }

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findByEmail(String email)
    {
        if(userRepository == null)
        {
            throw new NullPointerException("UserRepository is null");
        }

        // FIX FOR t25: return null instead of throwing
        Optional<User> userOpt = userRepository.findByEmail(email);
        return userOpt.orElse(null);
    }
}
