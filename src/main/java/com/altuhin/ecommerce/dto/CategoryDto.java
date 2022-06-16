package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class CategoryDto implements Serializable {
    private String categoryName;
    private String description;

}
