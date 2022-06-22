package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.OrderDto;
import com.altuhin.ecommerce.entity.Customer;
import com.altuhin.ecommerce.entity.Employee;
import com.altuhin.ecommerce.entity.Order;
import com.altuhin.ecommerce.entity.Shipper;
import com.altuhin.ecommerce.reporsitory.CustomerRepository;
import com.altuhin.ecommerce.reporsitory.EmployeeRepository;
import com.altuhin.ecommerce.reporsitory.OrderRepository;
import com.altuhin.ecommerce.reporsitory.ShipperRepository;
import com.altuhin.ecommerce.service.mapper.OrderTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final ShipperRepository shipperRepository;

    public OrderDto saveOrder(OrderDto orderDto) {

        Customer customer = customerRepository.findById(orderDto.getCustomerId()).orElseThrow(
                () -> new EntityNotFoundException("Customer With This Id is not Found!")
        );
        Employee employee = employeeRepository.findById(orderDto.getEmployeeId()).orElseThrow(
                () -> new EntityNotFoundException("Employee With This Id is not Found!")
        );

        Shipper shipper = shipperRepository.findById(orderDto.getFreight()).orElseThrow(
                () -> new EntityNotFoundException("Shipper With This Id is not Found!")
        );

        Order mapToOrder = OrderTransformService.mapToOrder(orderDto);
        mapToOrder.setCustomer(customer);
        mapToOrder.setEmployee(employee);
        mapToOrder.setShipper(shipper);
        Order order = orderRepository.save(mapToOrder);

        return OrderTransformService.mapToOrderDto(order);
    }

    public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Order With This Id is not Found!")
        );
        if (null != order) {
            orderRepository.save(OrderTransformService.mapToOrder(order, orderDto));
        }
        return OrderTransformService.mapToOrderDto(order);
    }

    public OrderDto deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Order With This Id is not Found!")
        );
        if (order != null) {
            order.setDelete(ApplicationUtility.ORDER_DELETED);
            orderRepository.save(order);
        }
        return OrderTransformService.mapToOrderDto(order);
    }

    public OrderDto getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Order With This Id is not Found!")
        );
        if (order != null) {
            order.setDelete(ApplicationUtility.ORDER_DELETED);
            orderRepository.save(order);
        }
        return OrderTransformService.mapToOrderDto(order);
    }

}
