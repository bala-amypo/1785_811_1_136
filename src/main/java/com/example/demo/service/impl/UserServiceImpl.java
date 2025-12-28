package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public User register(User u)
    {
        if(repo.findByEmail(u.getEmail()).isPresent())
            throw new BadRequestException("Email exists");

        u.setPassword(encoder.encode(u.getPassword()));
        u.setRole(User.Role.CUSTOMER.name());
        return repo.save(u);
    }

    @Override
    public User getById(Long id)
    {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
        return repo.findByEmail(email);
    }
}
