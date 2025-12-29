package com.example.demo.service.impl;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;
@Service
public class FinancialProfileServiceImpl implements FinancialProfileService
{
    private final FinancialProfileRepository repository;
    private final UserRepository userRepository;
    public FinancialProfileServiceImpl(FinancialProfileRepository repository,UserRepository userRepository)
    {
        this.repository=repository;
        this.userRepository=userRepository;
    }
    @Override
    public FinancialProfile createProfile(Long userId,FinancialProfile profile)
    {
        if(profile.getCreditScore()<300 || profile.getCreditScore()>900)
        {
            throw new BadRequestException("Invalid credit score");
        }
        User user=userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        profile.setUser(user);
        return repository.save(profile);
    }
    @Override
    public FinancialProfile getByUserId(Long userId)
    {
        return repository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}
