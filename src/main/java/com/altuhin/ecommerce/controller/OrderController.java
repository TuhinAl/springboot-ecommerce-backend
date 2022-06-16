package com.altuhin.ecommerce.controller;


import com.altuhin.ecommerce.dto.OrderDto;
import com.altuhin.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }
}
