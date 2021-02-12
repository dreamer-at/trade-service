package com.example.tradeservice.repository;

import com.example.tradeservice.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, UUID> {
    boolean existsByNameAndIsSupportedTrue (String name);
}
