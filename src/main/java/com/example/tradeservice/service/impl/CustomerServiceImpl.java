package com.example.tradeservice.service.impl;

import com.example.tradeservice.model.Customer;
import com.example.tradeservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Optional<Customer> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Customer create(Customer user) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }
}
