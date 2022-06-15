package com.altuhin.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "supplier_id")//todo mapping
    private Integer supplierId;

    @Column(name = "category_id") //todo mapping
    private Integer categoryId;

    @Column(name = "units_in_stock")
    private Integer unitInStock;

    @Column(name = "units_on_order")
    private Integer unitOnOrder;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "discontinued")
    private Integer discontinued;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
}
