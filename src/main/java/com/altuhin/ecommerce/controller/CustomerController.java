package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.CustomerDto;
import com.altuhin.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }
}
