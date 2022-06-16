package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.OrderDto;
import com.altuhin.ecommerce.entity.Order;

public class OrderTransformService {

    /**
     * private  LocalDate orderDate;
     * private  LocalDate ShippedDate;
     * private  Integer freight;
     * private  String shipName;
     * private  String shipAddress;
     * private  String shipCity;
     * private  String shipRegion;
     * private  String shipCountry;
     *
     * @param orderDto
     * @return
     */
    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();

        return order.setOrderDate(orderDto.getOrderDate()).setShippedDate(orderDto.getShippedDate())
                .setFreight(orderDto.getFreight()).setShipName(orderDto.getShipName()).setShipAddress(orderDto.getShipAddress())
                .setShipCity(orderDto.getShipCity()).setShipRegion(orderDto.getShipRegion()).setShipCountry(orderDto.getShipCountry());
    }

    public static Order mapToOrder(Order order, OrderDto orderDto) {

        return order.setOrderDate(orderDto.getOrderDate()).setShippedDate(orderDto.getShippedDate())
                .setFreight(orderDto.getFreight()).setShipName(orderDto.getShipName()).setShipAddress(orderDto.getShipAddress())
                .setShipCity(orderDto.getShipCity()).setShipRegion(orderDto.getShipRegion()).setShipCountry(orderDto.getShipCountry());
    }

    public static OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();

        return orderDto.setOrderDate(order.getOrderDate()).setShippedDate(order.getShippedDate())
                .setFreight(order.getFreight()).setShipName(order.getShipName()).setShipAddress(order.getShipAddress())
                .setShipCity(order.getShipCity()).setShipRegion(order.getShipRegion()).setShipCountry(order.getShipCountry());
    }

    public static OrderDto mapToOrderDto(Order order, OrderDto orderDto) {

        return orderDto.setOrderDate(order.getOrderDate()).setShippedDate(order.getShippedDate())
                .setFreight(order.getFreight()).setShipName(order.getShipName()).setShipAddress(order.getShipAddress())
                .setShipCity(order.getShipCity()).setShipRegion(order.getShipRegion()).setShipCountry(order.getShipCountry());
    }
}
