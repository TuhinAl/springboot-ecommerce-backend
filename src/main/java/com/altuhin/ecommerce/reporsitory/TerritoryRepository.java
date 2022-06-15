package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory, Integer>, QuerydslPredicateExecutor<Territory> {
}
