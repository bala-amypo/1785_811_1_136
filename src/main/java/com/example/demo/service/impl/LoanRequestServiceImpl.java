package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    public LoanRequest submitRequest(LoanRequest request) {
        return loanRequestRepository.save(request);
    }

    public List<LoanRequest> getRequestsByUser(long userId) {
        return loanRequestRepository.findByUserId(userId);
    }

    public LoanRequest getById(long id) {
        return loanRequestRepository.findById(id).orElse(null);
    }
}
