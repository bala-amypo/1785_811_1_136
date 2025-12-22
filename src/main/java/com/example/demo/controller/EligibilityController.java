package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/eligibility")
public class EligibilityController
{
    @GetMapping("/{userId}")
    public String checkEligibility(@PathVariable Long userId)
    {
        return "Eligible";
    }
}