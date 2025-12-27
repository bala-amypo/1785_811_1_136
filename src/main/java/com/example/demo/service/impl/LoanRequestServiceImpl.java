package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import com.example.demo.exception.*;
import java.time.*;
import java.util.*;

public class LoanRequestServiceImpl
{
    private final LoanRequestRepository repo;
    private final UserRepository userRepo;

    public LoanRequestServiceImpl(LoanRequestRepository r, UserRepository u)
    {
        repo=r; userRepo=u;
    }

    public LoanRequest submitRequest(LoanRequest lr)
    {
        if(lr.getRequestedAmount()==null || lr.getRequestedAmount()<=0)
            throw new BadRequestException("Invalid amount");

        userRepo.findById(lr.getUser().getId()).orElseThrow();

        lr.setStatus(LoanRequest.Status.PENDING.name());
        lr.setSubmittedAt(LocalDateTime.now());
        return repo.save(lr);
    }

    public List<LoanRequest> getRequestsByUser(Long id)
    {
        return repo.findByUserId(id);
    }

    public LoanRequest getById(Long id)
    {
        return repo.findById(id).orElse(null);
    }
}
