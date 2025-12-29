package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial-profile")
public class FinancialProfileController
{
    private final FinancialProfileService financialProfileService;

    public FinancialProfileController(FinancialProfileService financialProfileService)
    {
        this.financialProfileService = financialProfileService;
    }

    @PostMapping
    public ResponseEntity<FinancialProfile> create(@RequestBody FinancialProfile profile)
    {
        return ResponseEntity.ok(financialProfileService.createFinancialProfile(profile));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<FinancialProfile> getLatest(@PathVariable Long userId)
    {
        return ResponseEntity.ok(financialProfileService.getLatestProfileByUserId(userId));
    }
}
