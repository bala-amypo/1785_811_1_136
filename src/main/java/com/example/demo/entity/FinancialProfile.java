package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FinancialProfile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;
    private LocalDateTime lastUpdatedAt;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Double getMonthlyIncome()
    {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome)
    {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getMonthlyExpenses()
    {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(Double monthlyExpenses)
    {
        this.monthlyExpenses = monthlyExpenses;
    }

    public Double getExistingLoanEmi()
    {
        return existingLoanEmi;
    }

    public void setExistingLoanEmi(Double existingLoanEmi)
    {
        this.existingLoanEmi = existingLoanEmi;
    }

    public Integer getCreditScore()
    {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore)
    {
        this.creditScore = creditScore;
    }

    public Double getSavingsBalance()
    {
        return savingsBalance;
    }

    public void setSavingsBalance(Double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }

    public LocalDateTime getLastUpdatedAt()
    {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt)
    {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
