package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.entity.OrderDetails;
import com.altuhin.ecommerce.entity.OrderDetailsDto;
import com.altuhin.ecommerce.reporsitory.OrderDetailsRepository;
import com.altuhin.ecommerce.service.mapper.OrderDetailsTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsDto saveOrderDetails(OrderDetails orderDetails) {
        OrderDetails details = orderDetailsRepository.save(orderDetails);
        return OrderDetailsTransformService.mapToOrderDetailsDto(details);
    }

    public OrderDetailsDto updateOrderDetails(OrderDetailsDto orderDetailsDto, Integer id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).get();
        return OrderDetailsTransformService.mapToOrderDetailsDto(orderDetailsRepository
                .save(OrderDetailsTransformService.mapToOrderDetails(orderDetailsDto)));
    }

    public OrderDetailsDto deleteOrderDetails(Integer id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).get();

        return OrderDetailsTransformService.mapToOrderDetailsDto(orderDetailsRepository
                .save(orderDetails.setDelete(ApplicationUtility.ORDER_DETAILS_DELETED)));
    }

}
