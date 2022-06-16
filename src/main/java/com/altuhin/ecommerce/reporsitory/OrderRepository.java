package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderRepository extends JpaRepository<Order, Integer>, QuerydslPredicateExecutor<Order> {
}