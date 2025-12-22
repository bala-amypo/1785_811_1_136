package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/loan")
public class LoanRequestController
{
    @PostMapping("/apply")
    public String applyLoan()
    {
        return "Loan Applied";
    }
}