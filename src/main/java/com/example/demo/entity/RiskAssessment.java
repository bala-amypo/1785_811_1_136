package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String riskLevel;

    @OneToOne
    @JoinColumn(name = "loan_request_id",unique = true)
    private LoanRequest loanRequest;

    public RiskAssessment()
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

    public String getRiskLevel()
    {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel)
    {
        this.riskLevel = riskLevel;
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
