package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AuthController
{
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(UserServiceImpl userService, JwtUtil jwtUtil, UserRepository userRepository)
    {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request)
    {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(request.getPassword(), user.getPassword()))
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
