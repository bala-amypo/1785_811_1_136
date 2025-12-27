package com.example.demo.service;

import com.example.demo.entity.EligibilityResult;
import java.util.Optional;

public interface EligibilityService {

    EligibilityResult evaluateEligibility(Long loanRequestId);

    Optional<EligibilityResult> getByLoanRequestId(Long loanRequestId);
}
