package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.entity.OrderDetailsDto;
import com.altuhin.ecommerce.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @PostMapping()
    public OrderDetailsDto saveOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
        return orderDetailsService.saveOrderDetails(orderDetailsDto);
    }


}
