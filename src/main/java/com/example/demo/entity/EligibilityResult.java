package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EligibilityResult
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_request_id")
    private Long loanRequestId;

    private Double maxEligibleAmount;

    public Long getId()
    {
        return id;
    }

    public Long getLoanRequestId()
    {
        return loanRequestId;
    }

    public void setLoanRequestId(Long loanRequestId)
    {
        this.loanRequestId = loanRequestId;
    }

    public Double getMaxEligibleAmount()
    {
        return maxEligibleAmount;
    }

    public void setMaxEligibleAmount(Double maxEligibleAmount)
    {
        this.maxEligibleAmount = maxEligibleAmount;
    }
}
