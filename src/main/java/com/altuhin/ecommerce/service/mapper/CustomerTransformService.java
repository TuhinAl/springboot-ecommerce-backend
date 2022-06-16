package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.CustomerDto;
import com.altuhin.ecommerce.entity.Customer;

public class CustomerTransformService {

    /**
     * private String companyName;
     * private String contactName;
     * private String contactTitle;
     * private String address;
     * private String city;
     * private String country;
     * private String phone;
     */

    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        return customerDto.setCustomerName(customer.getCompanyName()).setContactName(customer.getContactName())
                .setContactTitle(customer.getContactTitle()).setAddress(customer.getAddress())
                .setCity(customer.getCity())
                .setCountry(customer.getCountry()).setPhone(customer.getPhone());
    }

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        return customerDto.setCustomerName(customer.getCompanyName()).setContactName(customer.getContactName())
                .setContactTitle(customer.getContactTitle()).setAddress(customer.getAddress())
                .setCity(customer.getCity())
                .setCountry(customer.getCountry()).setPhone(customer.getPhone());
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        return customer.setCompanyName(customerDto.getCustomerName()).setContactName(customerDto.getContactName())
                .setContactTitle(customerDto.getContactTitle()).setAddress(customerDto.getAddress()).setCity(customerDto.getCity())
                .setCountry(customerDto.getCountry()).setPhone(customerDto.getPhone());
    }

    public static Customer mapToCustomer(Customer customer, CustomerDto customerDto) {
        return customer.setCompanyName(customerDto.getCustomerName()).setContactName(customerDto.getContactName())
                .setContactTitle(customerDto.getContactTitle()).setAddress(customerDto.getAddress()).setCity(customerDto.getCity())
                .setCountry(customerDto.getCountry()).setPhone(customerDto.getPhone());
    }

}
