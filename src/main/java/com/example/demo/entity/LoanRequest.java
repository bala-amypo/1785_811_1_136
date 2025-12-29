package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_requests")
public class LoanRequest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private Integer tenureMonths;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate()
    {
        this.createdAt = LocalDateTime.now();
    }

    public LoanRequest()
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

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
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
