package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface EligibilityResultRepository
{
    Optional<EligibilityResult> findByLoanRequestId(Long id);
    EligibilityResult save(EligibilityResult er);
}
