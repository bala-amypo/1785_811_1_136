package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FinancialProfileServiceImpl {

    public FinancialProfileServiceImpl() {
    }

    public FinancialProfileServiceImpl(
            FinancialProfileRepository repo,
            UserRepository userRepo
    ) {
    }

    public FinancialProfile createOrUpdate(FinancialProfile fp) {
        fp.setLastUpdatedAt(LocalDateTime.now());
        return fp;
    }
    public FinancialProfile getByUserId(long userId)
    {
        return financialProfileRepository.findByUserId(userId).orElse(null);
    }

}
