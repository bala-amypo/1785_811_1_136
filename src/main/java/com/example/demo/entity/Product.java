package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double maxAmount;

    private Integer maxTenureMonths;

    private Double interestRate;

    public Product()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getMaxAmount()
    {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount)
    {
        this.maxAmount = maxAmount;
    }

    public Integer getMaxTenureMonths()
    {
        return maxTenureMonths;
    }

    public void setMaxTenureMonths(Integer maxTenureMonths)
    {
        this.maxTenureMonths = maxTenureMonths;
    }

    public Double getInterestRate()
    {
        return interestRate;
    }

    public void setInterestRate(Double interestRate)
    {
        this.interestRate = interestRate;
    }
}
