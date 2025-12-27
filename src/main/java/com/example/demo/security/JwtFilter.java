package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter {

    public JwtFilter() {
    }

    public JwtFilter(JwtUtil jwtUtil) {
    }

    public void doFilter(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain
    ) {
    }
}
