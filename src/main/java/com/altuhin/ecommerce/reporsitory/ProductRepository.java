package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductRepository extends JpaRepository<Product, Integer>, QuerydslPredicateExecutor<Product> {
}