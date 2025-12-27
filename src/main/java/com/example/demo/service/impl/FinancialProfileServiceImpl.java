package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import com.example.demo.exception.*;
import java.time.*;

public class FinancialProfileServiceImpl
{
    private final FinancialProfileRepository repo;
    private final UserRepository userRepo;

    public FinancialProfileServiceImpl(FinancialProfileRepository r, UserRepository u)
    {
        repo=r; userRepo=u;
    }

    public FinancialProfile createOrUpdate(FinancialProfile fp)
    {
        if(fp.getCreditScore()<300 || fp.getCreditScore()>900)
            throw new BadRequestException("Invalid credit score");

        Long uid = fp.getUser().getId();
        userRepo.findById(uid).orElseThrow(() -> new BadRequestException("User missing"));

        repo.findByUserId(uid).ifPresent(existing -> fp.setId(existing.getId()));

        fp.setLastUpdatedAt(LocalDateTime.now());
        return repo.save(fp);
    }

    public FinancialProfile getByUserId(Long id)
    {
        return repo.findByUserId(id).orElseThrow();
    }
}
