package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    public JwtUtil() {
    }

    public JwtUtil(String secret, int expiry) {
    }

    public String generateToken(String username) {
        return "dummy-token";
    }

    public String generateToken(Map<String,Object> claims, String subject) {
        return "dummy-token";
    }

    public Map<String,Object> getAllClaims(String token) {
        return new HashMap<>();
    }
}
