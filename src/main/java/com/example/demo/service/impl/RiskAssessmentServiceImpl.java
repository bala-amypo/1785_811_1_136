package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService
{
    private RiskAssessmentRepository riskAssessmentRepository;

    public RiskAssessmentServiceImpl()
    {
    }

    public RiskAssessmentServiceImpl(RiskAssessmentRepository riskAssessmentRepository)
    {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    @Override
    public RiskAssessment save(RiskAssessment assessment)
    {
        return riskAssessmentRepository.save(assessment);
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId)
    {
        return riskAssessmentRepository.findByLoanRequestId(loanRequestId).orElse(null);
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId)
    {
        RiskAssessment assessment = new RiskAssessment();
        assessment.setLoanRequestId(loanRequestId);
        return riskAssessmentRepository.save(assessment);
    }
}
