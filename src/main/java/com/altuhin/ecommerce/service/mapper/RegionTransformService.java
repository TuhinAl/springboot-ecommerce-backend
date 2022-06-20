package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.dto.TerritoryDto;
import com.altuhin.ecommerce.entity.Region;
import com.altuhin.ecommerce.entity.Territory;

import java.util.ArrayList;
import java.util.List;

public class RegionTransformService {


    public static Region mapToRegion(RegionDto regionDto) {

        Region region = new Region();
        List<Territory> territoryList = new ArrayList<>();

        for (TerritoryDto territoryDto : regionDto.getTerritoryList()) {
            Territory territory = new Territory();
            territory.setTerritoryDescription(territoryDto.getDescription());
            territoryList.add(territory);
        }
        region.setRegionDescription(regionDto.getRegionDescription());
        region.setTerritoryList(territoryList);
        return region;

    }

    public static Region mapToRegion(Region region, RegionDto regionDto) {

        List<Territory> territoryList = new ArrayList<>();

        for (TerritoryDto territoryDto : regionDto.getTerritoryList()) {
            Territory territory = new Territory();
            territory.setTerritoryDescription(territoryDto.getDescription());
            territoryList.add(territory);
        }
        region.setRegionDescription(region.getRegionDescription());
        region.setTerritoryList(territoryList);
        return region;

    }

    public static RegionDto mapToRegionDto(Region region) {

        RegionDto regionDto = new RegionDto();
        List<TerritoryDto> territoryDtoList = new ArrayList<>();

        for (Territory territory : region.getTerritoryList()) {
            TerritoryDto territoryDto = new TerritoryDto();
            territoryDto.setDescription(territory.getTerritoryDescription());
            territoryDtoList.add(territoryDto);
        }
        regionDto.setRegionDescription(region.getRegionDescription());
        regionDto.setTerritoryList(territoryDtoList);
        return regionDto;

    }

    public static RegionDto mapToRegionDto(Region region, RegionDto regionDto) {

        List<TerritoryDto> territoryDtoList = new ArrayList<>();

        for (Territory territory : region.getTerritoryList()) {
            TerritoryDto territoryDto = new TerritoryDto();
            territoryDto.setDescription(territory.getTerritoryDescription());
            territoryDtoList.add(territoryDto);
        }
        regionDto.setRegionDescription(region.getRegionDescription());
        regionDto.setTerritoryList(territoryDtoList);
        return regionDto;

    }
}
