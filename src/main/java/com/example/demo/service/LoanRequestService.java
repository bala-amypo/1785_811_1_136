package com.example.demo.service;

import com.example.demo.entity.LoanRequest;
import java.util.List;

public interface LoanRequestService {

    LoanRequest submitRequest(LoanRequest loanRequest);

    List<LoanRequest> getByUserId(Long userId);

    LoanRequest getById(Long id);
}
