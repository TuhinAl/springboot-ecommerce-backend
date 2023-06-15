package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.OrderDetailsDto;
import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public OrderDetailsDto updateEmployee(@RequestBody OrderDetailsDto orderDetailsDto, @PathVariable Integer id) {
        return orderDetailsService.updateOrderDetails(orderDetailsDto, id);
    }

    @PostMapping("/{id}")
    public OrderDetailsDto deleteEmployee(@PathVariable Integer id) {
        return orderDetailsService.deleteOrderDetails(id);
    }


}
