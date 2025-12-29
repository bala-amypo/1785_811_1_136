package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil
{
    private String secret;
    private long expiration;

    // REQUIRED for Spring + tests that expect no-arg
    public JwtUtil()
    {
        this.secret = "mysecretkey";
        this.expiration = 1000 * 60 * 60;
    }

    // REQUIRED for JwtConfig + tests (t41–t45)
    public JwtUtil(String secret,long expiration)
    {
        this.secret = secret;
        this.expiration = expiration;
    }

    // REQUIRED for existing usages
    public String generateToken(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // REQUIRED by AuthController + tests
    public String generateToken(Map<String,Object> claims,String subject)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
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

    public String extractUsername(String token)
    {
        return getAllClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token)
    {
        return getAllClaims(token).getExpiration().before(new Date());
    }
}
