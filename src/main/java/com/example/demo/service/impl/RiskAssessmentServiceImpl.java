package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.RiskAssessmentService;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService
{
    @Override
    public String assessRisk(long userId)
    {
        return "LOW";
    }
}
