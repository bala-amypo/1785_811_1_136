package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "financial_profiles")
public class FinancialProfile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer creditScore;

    private Double monthlyIncome;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    private User user;

    public FinancialProfile()
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

    public Integer getCreditScore()
    {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore)
    {
        this.creditScore = creditScore;
    }

    public Double getMonthlyIncome()
    {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome)
    {
        this.monthlyIncome = monthlyIncome;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
