package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double interestRate;
    private int maxTenureMonths;
    private double maxAmount;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }

    public int getMaxTenureMonths()
    {
        return maxTenureMonths;
    }

    public void setMaxTenureMonths(int maxTenureMonths)
    {
        this.maxTenureMonths = maxTenureMonths;
    }

    public double getMaxAmount()
    {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount)
    {
        this.maxAmount = maxAmount;
    }
}
