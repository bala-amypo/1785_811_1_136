package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/risk")
public class RiskLogController
{
    @GetMapping("/{userId}")
    public String getRisk(@PathVariable Long userId)
    {
        return "Low Risk";
    }
}