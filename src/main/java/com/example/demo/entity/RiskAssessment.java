package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RiskAssessment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;

    private int riskScore;

    private double dtiRatio;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getLoanRequestId()
    {
        return loanRequestId;
    }

    public void setLoanRequestId(Long loanRequestId)
    {
        this.loanRequestId = loanRequestId;
    }

    public int getRiskScore()
    {
        return riskScore;
    }

    public void setRiskScore(int riskScore)
    {
        this.riskScore = riskScore;
    }

    public double getDtiRatio()
    {
        return dtiRatio;
    }

    public void setDtiRatio(double dtiRatio)
    {
        this.dtiRatio = dtiRatio;
    }
}
