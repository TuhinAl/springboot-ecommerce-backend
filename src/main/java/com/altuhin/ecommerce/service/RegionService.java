package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.entity.QRegion;
import com.altuhin.ecommerce.entity.QTerritory;
import com.altuhin.ecommerce.entity.Region;
import com.altuhin.ecommerce.entity.Territory;
import com.altuhin.ecommerce.reporsitory.RegionRepository;
import com.altuhin.ecommerce.reporsitory.TerritoryRepository;
import com.altuhin.ecommerce.service.mapper.RegionTransformService;
import com.altuhin.ecommerce.service.mapper.TerritoryTransformService;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final TerritoryRepository territoryRepository;


    public RegionDto saveRegion(RegionDto regionDto) {

        Region region = RegionTransformService.mapToRegion(regionDto);
        List<Territory> territories = TerritoryTransformService.mapToTerritory(regionDto.getTerritoryList());
        List<Territory> territoryList = territoryRepository.saveAll(territories);
        region.setTerritoryList(territoryList);
        regionRepository.save(region);
        return regionDto;
    }


    public List<RegionDto> getRegionLeftTerritoryData() {

        final QRegion qRegion = QRegion.region;
        final QTerritory qTerritory = QTerritory.territory;
        JPAQuery<Region> regionJPAQuery = new JPAQuery<>();
        JPAQuery<Territory> territoryJPAQuery = new JPAQuery<>();

        List<Region> regionWithTerritoryList = regionJPAQuery.from(qRegion).leftJoin(qTerritory.region, qRegion).fetch();
        List<Territory> territoryWithRegionList = territoryJPAQuery.from(qTerritory).leftJoin(qTerritory.region, qRegion).fetch();
        List<RegionDto> regionDtoList = regionWithTerritoryList.stream().map(RegionTransformService::mapToRegionDto).collect(Collectors.toList());

        return regionDtoList;
    }

}
