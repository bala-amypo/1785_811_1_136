package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EligibilityServiceImpl
{

    private final LoanRequestRepository loanRequestRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            EligibilityResultRepository eligibilityResultRepository
    )
    {
        this.loanRequestRepository = loanRequestRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    public EligibilityResult calculateEligibility(Long loanRequestId)
    {
        LoanRequest loanRequest = loanRequestRepository
                .findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("LoanRequest not found"));

        Optional<EligibilityResult> existing =
                eligibilityResultRepository.findByLoanRequestId(loanRequestId);

        if (existing.isPresent())
        {
            return existing.get();
        }

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setMaxEligibleAmount(loanRequest.getRequestedAmount());

        return eligibilityResultRepository.save(result);
    }
}
