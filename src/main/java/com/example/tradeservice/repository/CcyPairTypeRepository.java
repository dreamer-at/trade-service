package com.example.tradeservice.repository;

import com.example.tradeservice.model.reference.CcyPairType;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CcyPairTypeRepository extends BaseRepository<CcyPairType, UUID> {

    boolean existsByName(String name);
    CcyPairType findByName(String name);
}
