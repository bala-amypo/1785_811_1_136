package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface LoanRequestRepository
{
    LoanRequest save(LoanRequest lr);
    Optional<LoanRequest> findById(Long id);
    List<LoanRequest> findByUserId(Long userId);
    List<LoanRequest> findAll();
}
