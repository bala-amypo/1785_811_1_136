package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil
{
    private final String secret;
    private final long expiry;

    public JwtUtil(String s,long e){secret=s;expiry=e;}

    public String generateToken(Map<String,Object> claims,String subject)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiry))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public Claims getAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
