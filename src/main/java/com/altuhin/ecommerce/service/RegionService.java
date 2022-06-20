package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.entity.Region;
import com.altuhin.ecommerce.entity.Territory;
import com.altuhin.ecommerce.reporsitory.RegionRepository;
import com.altuhin.ecommerce.reporsitory.TerritoryRepository;
import com.altuhin.ecommerce.service.mapper.RegionTransformService;
import com.altuhin.ecommerce.service.mapper.TerritoryTransformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final TerritoryRepository territoryRepository;


    public RegionDto saveRegion(RegionDto regionDto) {

        Region region = RegionTransformService.mapToRegion(regionDto);
        List<Territory> territories = TerritoryTransformService.mapToTerritory(regionDto.getTerritoryList());
        territoryRepository.saveAll(territories);
        regionRepository.save(region);
        return regionDto;
    }

}
