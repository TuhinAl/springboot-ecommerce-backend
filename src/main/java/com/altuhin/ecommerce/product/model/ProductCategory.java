package com.altuhin.ecommerce.product.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String categoryName;

}
