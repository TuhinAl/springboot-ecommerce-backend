package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, QuerydslPredicateExecutor<Employee> {
}
