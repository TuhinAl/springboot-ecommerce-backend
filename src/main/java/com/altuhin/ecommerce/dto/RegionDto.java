package com.altuhin.ecommerce.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class RegionDto implements Serializable {

    private String regionDescription;
    private List<TerritoryDto> territoryList;
}
