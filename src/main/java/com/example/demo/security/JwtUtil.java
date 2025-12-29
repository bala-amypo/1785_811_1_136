package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.Date;

public class JwtUtil
{
    private static final String SECRET = "mysecretkeymysecretkeymysecretkey";
    private static final long EXPIRATION = 1000 * 60 * 60;

    public String generateToken(String email)
    {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }

    public Claims getAllClaims(String token)
    {
        return Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody();
    }

    public String extractEmail(String token)
    {
        return getAllClaims(token).getSubject();
    }
}
