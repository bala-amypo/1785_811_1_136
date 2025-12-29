package com.example.demo.service.impl;
import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;
@Service
public class EligibilityServiceImpl implements EligibilityService
{
    private final EligibilityResultRepository repository;
    private final LoanRequestRepository loanRequestRepository;
    public EligibilityServiceImpl(EligibilityResultRepository repository,LoanRequestRepository loanRequestRepository)
    {
        this.repository=repository;
        this.loanRequestRepository=loanRequestRepository;
    }
    @Override
    public EligibilityResult evaluate(Long loanRequestId)
    {
        if(repository.findByLoanRequestId(loanRequestId).isPresent())
        {
            return repository.findByLoanRequestId(loanRequestId).get();
        }
        LoanRequest request=loanRequestRepository.findById(loanRequestId).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        EligibilityResult result=new EligibilityResult();
        result.setLoanRequest(request);
        result.setEligible(true);
        return repository.save(result);
    }
}
