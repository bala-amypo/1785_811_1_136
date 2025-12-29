package com.example.demo.dto;

public class LoanDtos
{
    private Long userId;
    private Double amount;
    private Integer tenureMonths;

    public LoanDtos()
    {
    }

    public LoanDtos(Long userId,Double amount,Integer tenureMonths)
    {
        this.userId = userId;
        this.amount = amount;
        this.tenureMonths = tenureMonths;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public Integer getTenureMonths()
    {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths)
    {
        this.tenureMonths = tenureMonths;
    }
}
