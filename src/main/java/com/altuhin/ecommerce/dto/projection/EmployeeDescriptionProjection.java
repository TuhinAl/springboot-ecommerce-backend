package com.altuhin.ecommerce.dto.projection;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDescriptionProjection {

    private String name;
    private String city;
    private String description;


    @QueryProjection
    public EmployeeDescriptionProjection(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }
}
