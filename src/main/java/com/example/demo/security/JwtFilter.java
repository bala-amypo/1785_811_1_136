package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter
{
    private final JwtUtil jwtUtil = new JwtUtil();

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer "))
        {
            String token = authHeader.substring(7);
            jwtUtil.getAllClaims(token);
        }
        chain.doFilter(request, response);
    }
}
