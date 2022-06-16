package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>, QuerydslPredicateExecutor<Supplier> {
}