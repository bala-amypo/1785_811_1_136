package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class JwtFilter implements Filter
{
    private final JwtUtil util;

    public JwtFilter(JwtUtil u){util=u;}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest r=(HttpServletRequest)req;
        String h=r.getHeader("Authorization");
        if(h!=null && h.startsWith("Bearer "))
        {
            try{util.getAllClaims(h.substring(7));}catch(Exception ignored){}
        }
        chain.doFilter(req,res);
    }
}
