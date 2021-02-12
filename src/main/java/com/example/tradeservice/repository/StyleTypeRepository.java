package com.example.tradeservice.repository;

import com.example.tradeservice.model.reference.StyleType;

import java.util.UUID;

public interface StyleTypeRepository extends BaseRepository<StyleType, UUID> {

    boolean existsByName(String name);
}
