package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class RepositoryStubConfig
{
    @Bean
    public UserRepository userRepository()
    {
        return new UserRepository()
        {
            public Optional<User> findByEmail(String email)
            {
                return Optional.empty();
            }

            public Optional<User> findById(Long id)
            {
                return Optional.empty();
            }

            public User save(User user)
            {
                return user;
            }
        };
    }
}
