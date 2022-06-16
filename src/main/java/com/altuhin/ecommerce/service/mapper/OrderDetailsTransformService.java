package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.entity.OrderDetails;
import com.altuhin.ecommerce.entity.OrderDetailsDto;

public class OrderDetailsTransformService {

    private static OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails) {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    private static OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails, OrderDetailsDto orderDetailsDto) {
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    private static OrderDetails mapToOrderDetails(OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = new OrderDetails();
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }

    private static OrderDetails mapToOrderDetails(OrderDetails orderDetails, OrderDetailsDto orderDetailsDto) {
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }
}
