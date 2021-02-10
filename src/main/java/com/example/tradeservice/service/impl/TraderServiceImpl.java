package com.example.tradeservice.service.impl;

import com.example.tradeservice.model.Trader;
import com.example.tradeservice.service.TraderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TraderServiceImpl implements TraderService {
    @Override
    public List<Trader> getAll() {
        return null;
    }

    @Override
    public Optional<Trader> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Trader create(Trader user) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Trader findByEmail(String email) {
        return null;
    }
}
