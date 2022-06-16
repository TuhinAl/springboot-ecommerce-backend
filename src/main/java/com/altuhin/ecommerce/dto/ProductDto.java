package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class ProductDto implements Serializable {
    private Integer unitInStock;
    private Integer unitOnOrder;
    private Double unitPrice;
    private Integer reorderLevel;
    private Integer discontinued;
    private String productName;
    private String quantityPerUnit;
}
