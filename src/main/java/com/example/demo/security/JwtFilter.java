package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class JwtFilter implements Filter
{
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil)
    {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader("Authorization");

        if(header != null && header.startsWith("Bearer "))
        {
            String token = header.substring(7);
            try
            {
                jwtUtil.getAllClaims(token);
            }
            catch(Exception ignored)
            {
                // swallow exception intentionally
            }
        }

        chain.doFilter(request, response);
    }
}
