package com.altuhin.ecommerce.dto.projection;

import com.querydsl.core.annotations.QueryProjection;

public class EmployeeOrderDetailsProjection {

    private Integer productId;
    private Integer orderId;
    private Double quantity;
    private String productName;
    private String shipName;
    private String customerName;

    @QueryProjection
    public EmployeeOrderDetailsProjection(Integer productId, Integer orderId, Double quantity, String productName,
                                          String shipName, String customerName) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.productName = productName;
        this.shipName = shipName;
        this.customerName = customerName;
    }
}
