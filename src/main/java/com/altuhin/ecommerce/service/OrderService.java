package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.OrderDto;
import com.altuhin.ecommerce.entity.Order;
import com.altuhin.ecommerce.reporsitory.OrderRepository;
import com.altuhin.ecommerce.service.mapper.OrderTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto saveOrder(Order order) {
        if (!order.equals(null)) {
            orderRepository.save(order);
        }
        return OrderTransformService.mapToOrderDto(order);
    }

    public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        if (null != order) {
            orderRepository.save(OrderTransformService.mapToOrder(order, orderDto));
        }
        return OrderTransformService.mapToOrderDto(order);
    }

    public OrderDto deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        if (order != null) {
            order.setDelete(ApplicationUtility.ORDER_DELETED);
            orderRepository.save(order);
        }
        return OrderTransformService.mapToOrderDto(order);
    }

}
