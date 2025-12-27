package com.example.demo.repository;

import com.example.demo.entity.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

    Optional<LoanRequest> findByUserId(Long userId);

    List<LoanRequest> findAllByUserId(Long userId);
}
