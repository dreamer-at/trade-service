package com.example.tradeservice.service;

import com.example.tradeservice.model.Trader;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TraderService {

    List<Trader> getAll();

    Optional<Trader> getById(UUID id);

    Trader create(Trader user);

    void deleteById(UUID id);

    Trader findByEmail(String email);
}
