package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.EmployeeDto;
import com.altuhin.ecommerce.dto.projection.EmployeeDescriptionProjection;
import com.altuhin.ecommerce.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployeeInfo(employeeDto);
        return "save successfully";
    }

    @GetMapping("/{id}")
    public EmployeeDescriptionProjection saveEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeTerritoryById(id);
    }


    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    @PostMapping("/{id}")
    public EmployeeDto deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

}
