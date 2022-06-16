package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShipperRepository extends JpaRepository<Shipper, Integer>, QuerydslPredicateExecutor<Shipper> {
}