package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;

@Service
public class LoanRequestServiceImpl implements LoanRequestService
{
    @Override
    public LoanRequest applyLoan(LoanRequest request)
    {
        return request;
    }
}
