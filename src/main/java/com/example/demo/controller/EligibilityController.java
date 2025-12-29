package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.EligibilityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eligibility")
public class EligibilityController
{
    private final EligibilityService eligibilityService;

    public EligibilityController(EligibilityService eligibilityService)
    {
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/{loanRequestId}")
    public EligibilityResult evaluate(@PathVariable Long loanRequestId)
    {
        return eligibilityService.evaluateEligibility(loanRequestId);
    }

    @GetMapping("/{loanRequestId}")
    public EligibilityResult getByLoanRequest(@PathVariable Long loanRequestId)
    {
        return eligibilityService.getByLoanRequestId(loanRequestId);
    }
}
