package com.altuhin.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "territories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Territory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "territory_id")
    private Integer id;

    @Column(name = "territory_description")
    private String territoryDescription;
}
