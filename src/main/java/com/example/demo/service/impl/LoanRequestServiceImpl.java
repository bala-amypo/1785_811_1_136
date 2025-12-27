package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository, UserRepository userRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    public LoanRequest submitRequest(LoanRequest loanRequest) {
        loanRequest.setStatus("PENDING");
        return loanRequestRepository.save(loanRequest);
    }

    public List<LoanRequest> getRequestsByUser(long userId) {
        return loanRequestRepository.findByUserId(userId);
    }

    public LoanRequest getById(long id) {
        return loanRequestRepository.findById(id).orElse(null);
    }
}
