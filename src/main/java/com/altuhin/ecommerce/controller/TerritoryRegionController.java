package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.dto.TerritoryDto;
import com.altuhin.ecommerce.service.RegionService;
import com.altuhin.ecommerce.service.TerritoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TerritoryRegionController {

    private final TerritoryService territoryService;
    private final RegionService regionService;


    @GetMapping("/territory-region")
    public List<TerritoryDto> getTerritoryWithRegionProjection() {
        return territoryService.getTerritoryLeftRegionData();
    }

    @GetMapping("/region-territory")
    public List<RegionDto> getRegionWithTerritoryProjection() {
        return regionService.getRegionLeftTerritoryData();
    }


}
