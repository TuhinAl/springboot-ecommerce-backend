package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.OrderDetailsDto;
import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.entity.OrderDetails;

public class OrderDetailsTransformService {

    public static OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails) {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    public static OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails, OrderDetailsDto orderDetailsDto) {
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    public static OrderDetails mapToOrderDetails(OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = new OrderDetails();
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }

    public static OrderDetails mapToOrderDetails(OrderDetails orderDetails, OrderDetailsDto orderDetailsDto) {
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }
}
