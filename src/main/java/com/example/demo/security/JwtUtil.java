package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil
{
    private final String secret;
    private final long expiryMillis;

    public JwtUtil(String secret, long expiryMillis)
    {
        this.secret = secret;
        this.expiryMillis = expiryMillis;
    }

    public String generateToken(Map<String, Object> claims, String subject)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims getAllClaims(String token)
    {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
