package com.example.demo.entity;

public class LoanRequest {

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    private User user;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
}
