package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-request")
public class LoanRequestController
{
    private final LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService)
    {
        this.loanRequestService = loanRequestService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<LoanRequest> submit(@PathVariable Long userId,@RequestBody LoanRequest request)
    {
        return ResponseEntity.ok(loanRequestService.submitRequest(userId,request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<LoanRequest>> getByUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(loanRequestService.getRequestsByUser(userId));
    }
}
