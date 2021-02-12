package com.example.tradeservice.repository;

import com.example.tradeservice.model.reference.ProductType;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductTypeRepository extends BaseRepository<ProductType, UUID>{

    boolean existsByName(String name);
}
