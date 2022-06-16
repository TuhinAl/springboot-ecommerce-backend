package com.altuhin.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
import java.util.List;

@Entity
@Table(name = "territories")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Territory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ter_id")
    private Integer id;

    @Column(name = "territory_description")
    private String territoryDescription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "territory")
    private List<EmployeeTerritory> employeeTerritories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
}
