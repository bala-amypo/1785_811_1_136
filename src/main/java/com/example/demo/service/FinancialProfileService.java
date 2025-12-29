package com.example.demo.service;
import com.example.demo.entity.FinancialProfile;
public interface FinancialProfileService
{
    FinancialProfile createProfile(Long userId,FinancialProfile profile);
    FinancialProfile getByUserId(Long userId);
}
