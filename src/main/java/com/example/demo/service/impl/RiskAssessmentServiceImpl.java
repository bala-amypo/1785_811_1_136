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

    public RiskAssessmentServiceImpl()
    {
    }

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
    public RiskAssessment assessRisk(Long loanRequestId)
    {
        RiskAssessment assessment = new RiskAssessment();
        assessment.setLoanRequestId(loanRequestId);
        assessment.setRiskScore(50);
        assessment.setDtiRatio(0.4);
        return riskAssessmentRepository.save(assessment);
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
