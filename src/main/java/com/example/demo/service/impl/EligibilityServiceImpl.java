package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import com.example.demo.exception.*;

public class EligibilityServiceImpl
{
    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository repo;

    public EligibilityServiceImpl(LoanRequestRepository l, FinancialProfileRepository f, EligibilityResultRepository e)
    {
        loanRepo=l; profileRepo=f; repo=e;
    }

    public EligibilityResult evaluateEligibility(Long reqId)
    {
        if(repo.findByLoanRequestId(reqId).isPresent())
            throw new BadRequestException("Already evaluated");

        LoanRequest lr = loanRepo.findById(reqId).orElseThrow();
        FinancialProfile fp = profileRepo.findByUserId(lr.getUser().getId()).orElseThrow();

        EligibilityResult er = new EligibilityResult();
        er.setLoanRequest(lr);
        er.setMaxEligibleAmount(Math.max(0, fp.getMonthlyIncome()*20));
        return repo.save(er);
    }

    public EligibilityResult getByLoanRequestId(Long id)
    {
        return repo.findByLoanRequestId(id).orElseThrow();
    }
}
