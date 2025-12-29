package com.example.demo.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtil
{
    private static final String SECRET="mysecretkeymysecretkeymysecretkeymysecretkey";
    private static final long EXPIRATION=1000*60*60;
    private Key getSigningKey()
    {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(java.util.Base64.getEncoder().encodeToString(SECRET.getBytes())));
    }
    public String generateToken(String username)
    {
        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();
    }
    public Claims getAllClaims(String token)
    {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }
    public String extractUsername(String token)
    {
        return getAllClaims(token).getSubject();
    }
    public boolean isTokenExpired(String token)
    {
        return getAllClaims(token).getExpiration().before(new Date());
    }
    public boolean validateToken(String token,String username)
    {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }
}
