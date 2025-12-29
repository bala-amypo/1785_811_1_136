package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final UserService userService;
    private final JwtUtil jwtUtil = new JwtUtil();

    public AuthController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request)
    {
        userService.validateLogin(request.getEmail(), request.getPassword());
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}
