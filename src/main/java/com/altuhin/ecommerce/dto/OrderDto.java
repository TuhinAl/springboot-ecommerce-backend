package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
public class OrderDto implements Serializable {

    private LocalDate orderDate;
    private LocalDate ShippedDate;
    private Integer freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipCountry;
}
