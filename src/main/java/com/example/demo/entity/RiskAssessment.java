package com.example.demo.entity;

public class RiskAssessment
{
    private Long id;
    private LoanRequest loanRequest;
    private Double riskScore;
    private Double dtiRatio;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public LoanRequest getLoanRequest(){return loanRequest;}
    public void setLoanRequest(LoanRequest loanRequest){this.loanRequest=loanRequest;}

    public Double getRiskScore(){return riskScore;}
    public void setRiskScore(Double riskScore){this.riskScore=riskScore;}

    public Double getDtiRatio(){return dtiRatio;}
    public void setDtiRatio(Double dtiRatio){this.dtiRatio=dtiRatio;}
}
