package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanRequest
{
    public enum Status
    {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double requestedAmount;
    private Integer tenureMonths;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
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
