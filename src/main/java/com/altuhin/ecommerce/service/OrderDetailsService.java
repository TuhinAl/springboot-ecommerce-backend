package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.entity.Order;
import com.altuhin.ecommerce.entity.OrderDetails;
import com.altuhin.ecommerce.entity.Product;
import com.altuhin.ecommerce.reporsitory.OrderDetailsRepository;
import com.altuhin.ecommerce.reporsitory.OrderRepository;
import com.altuhin.ecommerce.reporsitory.ProductRepository;
import com.altuhin.ecommerce.service.mapper.OrderDetailsTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public RegionDto.OrderDetailsDto saveOrderDetails(RegionDto.OrderDetailsDto orderDetailsDto) {
        Product product = productRepository.findById(orderDetailsDto.getProductId()).orElseThrow(
                () -> new EntityNotFoundException("Product With This Id is not Found!")
        );
        Order order = orderRepository.findById(orderDetailsDto.getOrderId()).orElseThrow(
                () -> new EntityNotFoundException("Order With This Id is not Found!")
        );
        OrderDetails orderDetails = OrderDetailsTransformService.mapToOrderDetails(orderDetailsDto);
        orderDetails.setProduct(product);
        orderDetails.setOrder(order);
        OrderDetails details = orderDetailsRepository.save(orderDetails);
        return OrderDetailsTransformService.mapToOrderDetailsDto(details);
    }

    public RegionDto.OrderDetailsDto updateOrderDetails(RegionDto.OrderDetailsDto orderDetailsDto, Integer id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("OrderDetails With This Id is not Found!")
        );
        return OrderDetailsTransformService.mapToOrderDetailsDto(orderDetailsRepository
                .save(OrderDetailsTransformService.mapToOrderDetails(orderDetailsDto)));
    }

    public RegionDto.OrderDetailsDto getOrderDetailsOfOrderByOrderId(Integer orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new EntityNotFoundException("Order With This Id is not Found!")
        );
        OrderDetails allByOrder = orderDetailsRepository.findAllByOrder(order);
        return OrderDetailsTransformService.mapToOrderDetailsDto(allByOrder);
    }

    public RegionDto.OrderDetailsDto deleteOrderDetails(Integer id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("OrderDetails With This Id is not Found!")
        );

        return OrderDetailsTransformService.mapToOrderDetailsDto(orderDetailsRepository
                .save(orderDetails.setDelete(ApplicationUtility.ORDER_DETAILS_DELETED)));
    }

}
