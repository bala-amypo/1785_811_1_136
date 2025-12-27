package com.example.demo.entity;

public class EligibilityResult
{
    private Long id;
    private LoanRequest loanRequest;
    private Double maxEligibleAmount;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public LoanRequest getLoanRequest(){return loanRequest;}
    public void setLoanRequest(LoanRequest loanRequest){this.loanRequest=loanRequest;}

    public Double getMaxEligibleAmount(){return maxEligibleAmount;}
    public void setMaxEligibleAmount(Double maxEligibleAmount){this.maxEligibleAmount=maxEligibleAmount;}
}
