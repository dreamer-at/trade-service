package com.example.tradeservice.service;

import com.example.tradeservice.dto.RequestCheckDTO;
import com.example.tradeservice.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAll();

    Optional<Customer> getById(UUID id);

    Customer create(Customer user);

    void deleteById(UUID id);

    Customer findByEmail(String email);

    boolean existsByNameAndIsSupportedIsTrue(String name);

}
