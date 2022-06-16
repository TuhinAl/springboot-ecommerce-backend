package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.CustomerDto;
import com.altuhin.ecommerce.entity.Customer;
import com.altuhin.ecommerce.reporsitory.CustomerRepository;
import com.altuhin.ecommerce.service.mapper.CustomerTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerDto saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return CustomerTransformService.mapToCustomerDto(customer);
    }

    public CustomerDto updateCustomer(CustomerDto customerDto, Integer id) {
        Customer customer = customerRepository.findById(id).get();
        Customer updatedCustomer = CustomerTransformService.mapToCustomer(customer, customerDto);
        customerRepository.save(updatedCustomer);
        return CustomerTransformService.mapToCustomerDto(updatedCustomer);
    }

    public CustomerDto deleteCustomer(CustomerDto customerDto, Integer id) {
        Customer customer = customerRepository.findById(id).get();
        customer.setDelete(ApplicationUtility.CUSTOMER_DELETED);
        customerRepository.save(customer);
        return CustomerTransformService.mapToCustomerDto(customer);
    }
}
