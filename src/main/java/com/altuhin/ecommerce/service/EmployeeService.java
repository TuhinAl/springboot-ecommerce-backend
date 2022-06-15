package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.dto.EmployeeDto;
import com.altuhin.ecommerce.dto.projection.EmployeeDescriptionProjection;
import com.altuhin.ecommerce.dto.projection.QEmployeeDescriptionProjection;
import com.altuhin.ecommerce.entity.Employee;
import com.altuhin.ecommerce.entity.EmployeeTerritory;
import com.altuhin.ecommerce.entity.QEmployee;
import com.altuhin.ecommerce.entity.QEmployeeTerritory;
import com.altuhin.ecommerce.entity.QTerritory;
import com.altuhin.ecommerce.entity.Territory;
import com.altuhin.ecommerce.reporsitory.EmployeeRepository;
import com.altuhin.ecommerce.reporsitory.TerritoryRepository;
import com.altuhin.ecommerce.service.mapper.EmployeeTransformService;
import com.altuhin.ecommerce.service.mapper.TerritoryTransformService;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EntityManager entityManager;
    private final EmployeeRepository employeeRepository;
    private final TerritoryRepository territoryRepository;


    public void saveEmployeeInfo(EmployeeDto employeeDto) {

        final Employee employee = EmployeeTransformService.mapToEmployeeDto(employeeDto, new Employee());
        List<Territory> territories = TerritoryTransformService.mapToTerritory(employeeDto.getTerritories());

        employeeRepository.save(employee);
        territoryRepository.saveAll(territories);
    }


    public EmployeeDescriptionProjection getEmployeeTerritoryById(Integer employeeId) {

        final QEmployee qEmployee = QEmployee.employee;
        final QTerritory qTerritory = QTerritory.territory;
        final QEmployeeTerritory qEmployeeTerritory = QEmployeeTerritory.employeeTerritory;

        JPAQuery<EmployeeTerritory> descriptionProjectionJPAQuery = new JPAQuery<>(entityManager);

        EmployeeDescriptionProjection employeeDescriptionProjection = descriptionProjectionJPAQuery
                .from(qEmployeeTerritory)
                .leftJoin(qEmployeeTerritory.employee, qEmployee)
                .leftJoin(qEmployeeTerritory.territory, qTerritory)
                .where(qEmployeeTerritory.employeeId.eq(employeeId))
                .select(new QEmployeeDescriptionProjection(qEmployee.firstName,
                        qEmployee.city, qTerritory.territoryDescription)).fetchFirst();

        return employeeDescriptionProjection;
    }
}
