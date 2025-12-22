package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RiskAssessmentLog;

public interface RiskAssessmentLogRepository extends JpaRepository<RiskAssessmentLog, Long> {
}
find src/main/java -type f -name "*.java" -exec sed -i 's/\u200b//g' {} +
