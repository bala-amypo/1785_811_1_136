package com.example.demo.service.impl;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LoanRequestServiceImpl implements LoanRequestService
{
    private final LoanRequestRepository repository;
    private final UserRepository userRepository;
    public LoanRequestServiceImpl(LoanRequestRepository repository,UserRepository userRepository)
    {
        this.repository=repository;
        this.userRepository=userRepository;
    }
    @Override
    public LoanRequest submit(Long userId,LoanRequest request)
    {
        if(request.getAmount()<=0)
        {
            throw new BadRequestException("Invalid amount");
        }
        User user=userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        request.setUser(user);
        return repository.save(request);
    }
    @Override
    public List<LoanRequest> getByUser(Long userId)
    {
        return repository.findByUserId(userId);
    }
}
