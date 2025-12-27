package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import com.example.demo.exception.*;

public class RiskAssessmentServiceImpl
{
    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final RiskAssessmentRepository repo;

    public RiskAssessmentServiceImpl(LoanRequestRepository l, FinancialProfileRepository f, RiskAssessmentRepository r)
    {
        loanRepo=l; profileRepo=f; repo=r;
    }

    public RiskAssessment assessRisk(Long id)
    {
        if(repo.findByLoanRequestId(id).isPresent())
            throw new BadRequestException("Already assessed");

        LoanRequest lr = loanRepo.findById(id).orElseThrow();
        FinancialProfile fp = profileRepo.findByUserId(lr.getUser().getId()).orElseThrow();

        double income = fp.getMonthlyIncome()==0 ? 1 : fp.getMonthlyIncome();
        double dti = fp.getExistingLoanEmi()/income;

        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequest(lr);
        ra.setDtiRatio(fp.getMonthlyIncome()==0?0.0:dti);
        ra.setRiskScore(Math.min(100, Math.max(0, (1-dti)*100)));
        return repo.save(ra);
    }

    public RiskAssessment getByLoanRequestId(Long id)
    {
        return repo.findByLoanRequestId(id).orElseThrow();
    }
}
