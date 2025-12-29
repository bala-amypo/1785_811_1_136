package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eligibility_results")
public class EligibilityResult
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean eligible;

    private Double maxEligibleAmount;

    @OneToOne
    @JoinColumn(name = "loan_request_id",unique = true)
    private LoanRequest loanRequest;

    public EligibilityResult()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean getEligible()
    {
        return eligible;
    }

    public void setEligible(Boolean eligible)
    {
        this.eligible = eligible;
    }

    public Double getMaxEligibleAmount()
    {
        return maxEligibleAmount;
    }

    public void setMaxEligibleAmount(Double maxEligibleAmount)
    {
        this.maxEligibleAmount = maxEligibleAmount;
    }

    public LoanRequest getLoanRequest()
    {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequest loanRequest)
    {
        this.loanRequest = loanRequest;
    }
}
