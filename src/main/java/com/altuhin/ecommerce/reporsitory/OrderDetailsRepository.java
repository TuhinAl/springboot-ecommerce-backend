package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>, QuerydslPredicateExecutor<OrderDetails> {
}