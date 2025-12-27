package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanRequestServiceImpl {

    public LoanRequestServiceImpl() {
    }

    public LoanRequestServiceImpl(
            LoanRequestRepository repo,
            UserRepository userRepo
    ) {
    }

    public LoanRequest submitRequest(LoanRequest lr) {
        lr.setStatus(LoanRequest.Status.PENDING);
        return lr;
    }

    public List<LoanRequest> getRequestsByUser(long userId) {
        return new ArrayList<>();
    }

    public LoanRequest getById(long id) {
        return new LoanRequest();
    }
}
