package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            EligibilityResultRepository eligibilityResultRepository
    ) {
        this.loanRequestRepository = loanRequestRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {

        LoanRequest loanRequest = loanRequestRepository
                .findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("LoanRequest not found"));

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loanRequest);

        double eligibleAmount = loanRequest.getRequestedAmount() * 0.6;
        result.setMaxEligibleAmount(eligibleAmount);

        return eligibilityResultRepository.save(result);
    }

    @Override
    public Optional<EligibilityResult> getByLoanRequestId(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId);
    }
}
