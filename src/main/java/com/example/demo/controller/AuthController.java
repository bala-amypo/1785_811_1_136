package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserService userService,JwtUtil jwtUtil,BCryptPasswordEncoder passwordEncoder)
    {
        this.userService=userService;
        this.jwtUtil=jwtUtil;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request)
    {
        User user=userService.findByEmail(request.getEmail());
        if(user==null||!passwordEncoder.matches(request.getPassword(),user.getPassword()))
        {
            throw new RuntimeException("Invalid credentials");
        }
        String token=jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
