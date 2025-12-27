package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface RiskAssessmentRepository
{
    Optional<RiskAssessment> findByLoanRequestId(Long id);
    RiskAssessment save(RiskAssessment ra);
}
