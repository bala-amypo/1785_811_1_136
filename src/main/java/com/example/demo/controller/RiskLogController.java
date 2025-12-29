package com.example.demo.controller;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
public class RiskLogController
{
    private final RiskAssessmentService riskAssessmentService;

    public RiskLogController(RiskAssessmentService riskAssessmentService)
    {
        this.riskAssessmentService = riskAssessmentService;
    }

    @PostMapping("/{loanRequestId}")
    public ResponseEntity<RiskAssessment> assess(@PathVariable Long loanRequestId)
    {
        return ResponseEntity.ok(riskAssessmentService.assessRisk(loanRequestId));
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<RiskAssessment> get(@PathVariable Long loanRequestId)
    {
        return ResponseEntity.ok(riskAssessmentService.getRiskByLoanRequestId(loanRequestId));
    }
}
