package com.altuhin.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SupplierDto implements Serializable {
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String homepage;
}
