package com.altuhin.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate ShippedDate;

    @Column(name = "freight")
    private Integer freight;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship_postal")
    private String shipPostal;

    @Column(name = "ship_country")
    private String shipCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_via", nullable = false)
    private Shipper shipper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetails> orderDetailsList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
