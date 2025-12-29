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

    @PostMapping("/{userId}")
    public ResponseEntity<FinancialProfile> create(@PathVariable Long userId,@RequestBody FinancialProfile profile)
    {
        return ResponseEntity.ok(financialProfileService.createProfile(userId,profile));
    }
}
