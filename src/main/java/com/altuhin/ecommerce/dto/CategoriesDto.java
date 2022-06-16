package com.altuhin.ecommerce.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CategoriesDto implements Serializable {
    private String categoryName;
    private String description;

}
