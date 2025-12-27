package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

public class AuthController
{
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserServiceImpl userService, JwtUtil jwtUtil, UserRepository userRepository)
    {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public ResponseEntity<AuthResponse> login(AuthRequest request)
    {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        if(!encoder.matches(request.getPassword(), user.getPassword()))
        {
            throw new RuntimeException("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());

        String token = jwtUtil.generateToken(claims, user.getEmail());

        return ResponseEntity.ok(new AuthResponse(token, user.getEmail()));
    }
}
