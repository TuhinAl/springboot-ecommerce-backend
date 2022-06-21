package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EntityManager entityManager;
    private final EmployeeRepository employeeRepository;
    private final TerritoryRepository territoryRepository;


    public EmployeeDto saveEmployeeInfo(EmployeeDto employeeDto) {

        Employee employee = EmployeeTransformService.mapToEmployeeDto(employeeDto, new Employee());
        List<Territory> territories = TerritoryTransformService.mapToTerritory(employeeDto.getTerritories());
        Employee save = employeeRepository.save(employee);
        territoryRepository.saveAll(territories);
        return EmployeeTransformService.mapToEmployeeDto(save);
    }


    public Page<EmployeeDescriptionProjection> getEmployeeTerritoryById(Integer[] employeeId) {

        List<Integer> idList = Arrays.asList(
                employeeId
        );

        Integer page = 0;
        Integer size = 10;

        Pageable pageable = PageRequest.of(page, size);
        final QEmployee qEmployee = QEmployee.employee;
        final QTerritory qTerritory = QTerritory.territory;
        final QEmployeeTerritory qEmployeeTerritory = QEmployeeTerritory.employeeTerritory;

        JPAQuery<EmployeeTerritory> descriptionProjectionJPAQuery = new JPAQuery<>(entityManager);

        List<EmployeeDescriptionProjection> employeeDescriptionProjectionList = descriptionProjectionJPAQuery.from(qEmployeeTerritory)
                .leftJoin(qEmployeeTerritory.employee, qEmployee).leftJoin(qEmployeeTerritory.territory, qTerritory)
                .where(qEmployeeTerritory.employeeId.in(idList)).select(new QEmployeeDescriptionProjection(qEmployee.firstName, qEmployee.city,
                        qTerritory.territoryDescription))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        return new PageImpl<>(employeeDescriptionProjectionList, pageable, descriptionProjectionJPAQuery.fetchCount());
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee with this id"));
        employee.setFirstName(employeeDto.getFirstName()).setTitle(employeeDto.getTitle())
                .setAddress(employeeDto.getAddress()).setHomePhone(employeeDto.getHomePhone());
        employeeRepository.save(employee);
        return EmployeeTransformService.mapToEmployee(employeeDto, employee);
    }

    public EmployeeDto deleteEmployee(Integer id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employee with this id"));
        employee.setDelete(ApplicationUtility.EMPLOYEE_DELETED);
        employeeRepository.save(employee);

        return EmployeeTransformService.mapToEmployee(employee);
    }
}
