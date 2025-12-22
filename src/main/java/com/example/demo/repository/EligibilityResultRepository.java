
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;
public interface EligibilityResultRepository extends JpaRepository<User,Long>
{
}