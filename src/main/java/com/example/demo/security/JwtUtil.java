package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class JwtUtil
{
    private final Key key;
    private final long expiration;

    public JwtUtil(String secret, long expiration)
    {
        this.key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        this.expiration = expiration;
    }

    public String generateToken(Map<String, Object> claims, String subject)
    {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS256, key)
            .compact();
    }

    public Claims getAllClaims(String token)
    {
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();
    }
}
