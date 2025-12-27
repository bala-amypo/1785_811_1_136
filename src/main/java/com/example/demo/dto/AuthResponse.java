package com.example.demo.dto;

public class AuthResponse
{
    private String token;
    private String email;

    public AuthResponse(String t,String e){token=t;email=e;}

    public String getToken(){return token;}
    public String getEmail(){return email;}
}
