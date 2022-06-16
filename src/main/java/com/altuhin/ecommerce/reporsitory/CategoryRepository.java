package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CategoryRepository extends JpaRepository<Category, Integer>, QuerydslPredicateExecutor<Category> {
}