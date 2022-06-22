package com.altuhin.ecommerce.controller;


import com.altuhin.ecommerce.dto.OrderDto;
import com.altuhin.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public OrderDto updateEmployee(@RequestBody OrderDto employeeDto, @PathVariable Integer id) {
        return orderService.updateOrder(employeeDto, id);
    }

    @GetMapping("/{id}")
    public OrderDto getEmployeeById(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }

    @PostMapping("/{id}")
    public OrderDto deleteEmployee(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }
}
