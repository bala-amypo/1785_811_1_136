package com.example.demo.service.impl;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.RiskAssessment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;
@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService
{
    private final RiskAssessmentRepository repository;
    private final LoanRequestRepository loanRequestRepository;
    public RiskAssessmentServiceImpl(RiskAssessmentRepository repository,LoanRequestRepository loanRequestRepository)
    {
        this.repository=repository;
        this.loanRequestRepository=loanRequestRepository;
    }
    @Override
    public RiskAssessment assess(Long loanRequestId)
    {
        if(repository.findByLoanRequestId(loanRequestId).isPresent())
        {
            return repository.findByLoanRequestId(loanRequestId).get();
        }
        LoanRequest request=loanRequestRepository.findById(loanRequestId).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        RiskAssessment risk=new RiskAssessment();
        risk.setLoanRequest(request);
        risk.setRiskLevel("LOW");
        return repository.save(risk);
    }
}
