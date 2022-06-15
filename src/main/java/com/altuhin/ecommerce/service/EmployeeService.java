package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.dto.EmployeeDto;
import com.altuhin.ecommerce.reporsitory.EmployeeRepository;
import com.altuhin.ecommerce.reporsitory.TerritoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TerritoryRepository territoryRepository;


    public EmployeeService(EmployeeRepository employeeRepository,
                           TerritoryRepository territoryRepository) {
        this.employeeRepository = employeeRepository;
        this.territoryRepository = territoryRepository;
    }


    public void saveEmployeeInfo(EmployeeDto employeeDto) {

    }
}
