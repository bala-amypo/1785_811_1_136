package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanRequest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double requestedAmount;
    private Integer tenureMonths;
    private String status;
    private LocalDateTime submittedAt;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Double getRequestedAmount()
    {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount)
    {
        this.requestedAmount = requestedAmount;
    }

    public Integer getTenureMonths()
    {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths)
    {
        this.tenureMonths = tenureMonths;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt()
    {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt)
    {
        this.submittedAt = submittedAt;
    }
}
