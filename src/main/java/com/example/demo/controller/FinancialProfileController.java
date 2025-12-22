package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/financial-profile")
public class FinancialProfileController
{
@GetMapping("/{userId}")
public String getProfile(@PathVariable Long userId)
{
return "Profile Data";
}
}