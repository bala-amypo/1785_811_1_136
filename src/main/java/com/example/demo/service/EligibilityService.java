package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EligibilityServiceImpl implements EligibilityService
{
    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository,
            EligibilityResultRepository eligibilityResultRepository)
    {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId)
    {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        if (eligibilityResultRepository.findByLoanRequestId(loanRequestId).isPresent())
        {
            throw new BadRequestException("Eligibility already evaluated");
        }

        FinancialProfile profile = financialProfileRepository.findByUserId(
                loanRequest.getUser().getId()
        ).orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        double disposableIncome =
                profile.getMonthlyIncome()
                        - profile.getMonthlyExpenses()
                        - profile.getExistingLoanEmi();

        double maxEligibleAmount = Math.max(disposableIncome * loanRequest.getTenureMonths(), 0);

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setMaxEligibleAmount(maxEligibleAmount);

        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId)
    {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }
}
