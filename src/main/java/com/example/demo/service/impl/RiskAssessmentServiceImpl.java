package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService
{
    private LoanRequestRepository loanRequestRepository;
    private FinancialProfileRepository financialProfileRepository;
    private RiskAssessmentRepository riskAssessmentRepository;

    // REQUIRED by Spring
    public RiskAssessmentServiceImpl()
    {
    }

    // Used by tests
    public RiskAssessmentServiceImpl(RiskAssessmentRepository riskAssessmentRepository)
    {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    // Used by tests
    public RiskAssessmentServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository,
            RiskAssessmentRepository riskAssessmentRepository)
    {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
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
}
