package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.LoanEligibilityService;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService
{
    @Override
    public boolean checkEligibility(long userId)
    {
        return true;
    }
}
