package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService
{
    private final RiskAssessmentRepository riskAssessmentRepository;

    public RiskAssessmentServiceImpl(RiskAssessmentRepository riskAssessmentRepository)
    {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    @Override
    public RiskAssessment assessRisk(long loanRequestId)
    {
        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequestId(loanRequestId);
        ra.setRiskScore(50);
        ra.setDtiRatio(0.4);
        ra.setRiskLevel("MEDIUM");
        return riskAssessmentRepository.save(ra);
    }

    @Override
    public RiskAssessment getByLoanRequestId(long loanRequestId)
    {
        return riskAssessmentRepository.findByLoanRequestId(loanRequestId).orElse(null);
    }
}
