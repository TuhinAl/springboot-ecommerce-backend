package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String title;

    private String titleOfCourtesy;

    private Date birthDate;

    private Date hireDate;

    private String address;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private String homePhone;

    private String extension;

    private Byte[] photo;

    private String notes;

    private String photoPath;

    private Integer reportsTo;

    private List<TerritoryDto> territories;
}
