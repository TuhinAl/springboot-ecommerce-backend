package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class CustomerDto implements Serializable {
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String country;
    private String phone;
}
