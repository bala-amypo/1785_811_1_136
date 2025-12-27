package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl {

    private final RiskAssessmentRepository repository;

    public RiskAssessmentServiceImpl(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public RiskAssessment assessRisk(long loanRequestId) {
        return repository.findByLoanRequestId(loanRequestId).orElse(null);
    }
}
