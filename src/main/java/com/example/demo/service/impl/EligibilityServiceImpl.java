package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService
{
    @Autowired
    private EligibilityResultRepository eligibilityResultRepository;

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @Override
    public EligibilityResult checkEligibility(Long loanRequestId)
    {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId).orElse(null);
        if(loanRequest == null)
        {
            return null;
        }
        EligibilityResult result = eligibilityResultRepository.findByLoanRequestId(loanRequestId).orElse(null);
        if(result == null)
        {
            result = new EligibilityResult();
            result.setLoanRequestId(loanRequestId);
            result.setMaxEligibleAmount(loanRequest.getRequestedAmount());
        }
        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId)
    {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId).orElse(null);
    }
}
