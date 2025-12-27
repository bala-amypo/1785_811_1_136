package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.repository.*;
import com.example.demo.entity.*;
import com.example.demo.security.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

public class AuthController
{
    private final UserServiceImpl service;
    private final JwtUtil util;
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public AuthController(UserServiceImpl s,JwtUtil u,UserRepository r)
    {
        service=s;util=u;repo=r;
    }

    public ResponseEntity<AuthResponse> login(AuthRequest req)
    {
        User u=repo.findByEmail(req.getEmail()).orElseThrow();
        if(!encoder.matches(req.getPassword(),u.getPassword()))
            throw new RuntimeException();

        Map<String,Object> claims=new HashMap<>();
        claims.put("email",u.getEmail());
        claims.put("role",u.getRole());
        claims.put("userId",u.getId());

        String token=util.generateToken(claims,u.getEmail());
        return ResponseEntity.ok(new AuthResponse(token,u.getEmail()));
    }
}
