package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.EmployeeDto;
import com.altuhin.ecommerce.entity.Employee;

public class EmployeeTransformService {

    public static Employee mapToEmployeeDto(EmployeeDto employeeDto, Employee employee) {
        return employee.setCity(employeeDto.getCity()).setFirstName(employeeDto.getFirstName())
                .setLastName(employeeDto.getLastName()).setTitleOfCourtesy(employeeDto.getTitleOfCourtesy())
                .setBirthDate(employeeDto.getBirthDate()).setHireDate(employeeDto.getHireDate())
                .setAddress(employeeDto.getAddress()).setPostalCode(employeeDto.getPostalCode())
                .setExtension(employeeDto.getExtension()).setCountry(employeeDto.getCountry())
                .setHomePhone(employeeDto.getHomePhone()).setPhoto(employeeDto.getPhoto())
                .setNotes(employeeDto.getNotes()).setPhotoPath(employeeDto.getPhotoPath());
    }

    public static EmployeeDto mapToEmployee(EmployeeDto employee, Employee employeeDto) {

        return employee.setCity(employeeDto.getCity()).setFirstName(employeeDto.getFirstName())
                .setLastName(employeeDto.getLastName()).setTitleOfCourtesy(employeeDto.getTitleOfCourtesy())
                .setBirthDate(employeeDto.getBirthDate()).setHireDate(employeeDto.getHireDate())
                .setAddress(employeeDto.getAddress()).setPostalCode(employeeDto.getPostalCode())
                .setExtension(employeeDto.getExtension()).setCountry(employeeDto.getCountry())
                .setHomePhone(employeeDto.getHomePhone()).setPhoto(employeeDto.getPhoto())
                .setNotes(employeeDto.getNotes()).setPhotoPath(employeeDto.getPhotoPath());
    }
}
