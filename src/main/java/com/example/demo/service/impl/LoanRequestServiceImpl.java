package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public LoanRequest submitRequest(LoanRequest loanRequest) {
        loanRequest.setStatus("PENDING");
        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getByUserId(Long userId) {
        return loanRequestRepository.findByUserId(userId);
    }

    @Override
    public LoanRequest getById(Long id) {
        return loanRequestRepository.findById(id).orElse(null);
    }
}
