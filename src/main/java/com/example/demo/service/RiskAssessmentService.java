package com.example.demo.service;

import com.example.demo.entity.RiskAssessment;

public interface RiskAssessmentService
{
    RiskAssessment save(RiskAssessment assessment);
    RiskAssessment getByLoanRequestId(Long loanRequestId);
    RiskAssessment assessRisk(Long loanRequestId);
}
