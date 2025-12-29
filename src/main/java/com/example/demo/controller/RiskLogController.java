package com.example.demo.controller;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk")
public class RiskLogController
{
    private final RiskAssessmentService riskAssessmentService;

    public RiskLogController(RiskAssessmentService riskAssessmentService)
    {
        this.riskAssessmentService=riskAssessmentService;
    }

    @PostMapping("/{loanRequestId}")
    public RiskAssessment assess(@PathVariable Long loanRequestId)
    {
        return riskAssessmentService.assessRisk(loanRequestId);
    }
}
