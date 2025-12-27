package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface FinancialProfileRepository
{
    Optional<FinancialProfile> findByUserId(Long userId);
    FinancialProfile save(FinancialProfile fp);
}
