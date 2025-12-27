package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService
{
    private LoanRequestRepository loanRequestRepository;
    private UserRepository userRepository;

    // REQUIRED by Spring
    public LoanRequestServiceImpl()
    {
    }

    // Used by tests
    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository)
    {
        this.loanRequestRepository = loanRequestRepository;
    }

    // Used by tests
    public LoanRequestServiceImpl(
            LoanRequestRepository loanRequestRepository,
            UserRepository userRepository)
    {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanRequest submitRequest(LoanRequest request)
    {
        return loanRequestRepository.save(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId)
    {
        return loanRequestRepository.findByUserId(userId);
    }

    @Override
    public LoanRequest getById(Long id)
    {
        return loanRequestRepository.findById(id).orElse(null);
    }
}
