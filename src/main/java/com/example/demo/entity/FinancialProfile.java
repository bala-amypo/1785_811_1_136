package com.example.demo.entity;

import java.time.LocalDateTime;

public class FinancialProfile {

    private User user;
    private double savingsBalance;
    private double existingLoanEmi;
    private LocalDateTime lastUpdatedAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getExistingLoanEmi() {
        return existingLoanEmi;
    }

    public void setExistingLoanEmi(double existingLoanEmi) {
        this.existingLoanEmi = existingLoanEmi;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
