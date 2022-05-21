package com.altuhin.ecommerce.product.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String sku;

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private BigDecimal unitPrice;

    @Column()
    private String imageUrl;

    @Column()
    private Boolean active;

    @Column()
    private int UnitInStock;

    @Column()
    @CreationTimestamp
    private Date dateCreate;

    @Column
    @UpdateTimestamp
    private Date lastUpdate;

}
