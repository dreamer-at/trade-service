package com.example.tradeservice.service.impl;

import com.example.tradeservice.model.Customer;
import com.example.tradeservice.repository.CustomerRepository;
import com.example.tradeservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Optional<Customer> getById(final UUID id) {
        return Optional.empty();
    }

    @Override
    public Customer create(final Customer user) {
        return null;
    }

    @Override
    public void deleteById(final UUID id) {

    }

    @Override
    public Customer findByEmail(final String email) {
        return null;
    }

    @Override
    public boolean existsByNameAndIsSupportedIsTrue(final String name) {
        Objects.requireNonNull(name);
        return repository.existsByNameAndIsSupportedTrue(name);
    }
}
