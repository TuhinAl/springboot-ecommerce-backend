package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, QuerydslPredicateExecutor<Customer> {
}