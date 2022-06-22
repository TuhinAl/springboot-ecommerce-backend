package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.entity.OrderDetails;

public class OrderDetailsTransformService {

    public static RegionDto.OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails) {
        RegionDto.OrderDetailsDto orderDetailsDto = new RegionDto.OrderDetailsDto();
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    public static RegionDto.OrderDetailsDto mapToOrderDetailsDto(OrderDetails orderDetails, RegionDto.OrderDetailsDto orderDetailsDto) {
        return orderDetailsDto.setUnitPrice(orderDetails.getUnitPrice()).setDiscount(orderDetails.getDiscount())
                .setQuantity(orderDetails.getQuantity());
    }

    public static OrderDetails mapToOrderDetails(RegionDto.OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = new OrderDetails();
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }

    public static OrderDetails mapToOrderDetails(OrderDetails orderDetails, RegionDto.OrderDetailsDto orderDetailsDto) {
        return orderDetails.setUnitPrice(orderDetailsDto.getUnitPrice()).setDiscount(orderDetailsDto.getDiscount())
                .setQuantity(orderDetailsDto.getQuantity());
    }
}
