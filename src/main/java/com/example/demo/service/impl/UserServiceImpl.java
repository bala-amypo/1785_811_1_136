package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepository userRepository) {
    }

    public User getById(long id) {
        User u = new User();
        u.setId(id);
        return u;
    }

    public User findByEmail(String email) {
        User u = new User();
        u.setEmail(email);
        return u;
    }
}
