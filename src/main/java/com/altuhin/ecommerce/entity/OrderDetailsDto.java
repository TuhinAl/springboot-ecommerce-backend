package com.altuhin.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)

public class OrderDetailsDto implements Serializable {
    private Integer unitPrice;
    private Integer quantity;
    private Integer discount;
}
