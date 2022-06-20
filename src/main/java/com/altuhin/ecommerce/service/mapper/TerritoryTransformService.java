package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.TerritoryDto;
import com.altuhin.ecommerce.entity.Territory;

import java.util.ArrayList;
import java.util.List;

public class TerritoryTransformService {

    public static List<Territory> mapToTerritory(List<TerritoryDto> territoryDtoList) {
        List<Territory> newTerritoryList = new ArrayList<>();
        for (TerritoryDto territoryIterate : territoryDtoList) {
            Territory newTerritory = new Territory();
            newTerritoryList.add(newTerritory.setTerritoryDescription(territoryIterate.getDescription()));
        }
        return newTerritoryList;
    }

    public static List<Territory> mapToTerritory(List<Territory> newTerritoryList, List<TerritoryDto> territoryDtoList) {
        for (TerritoryDto territoryIterate : territoryDtoList) {
            Territory newTerritory = new Territory();
            newTerritoryList.add(newTerritory.setTerritoryDescription(territoryIterate.getDescription()));
        }
        return newTerritoryList;
    }

    public static List<TerritoryDto> mapToTerritoryDto(List<TerritoryDto> territoryDtoList, List<Territory> territory) {

        List<TerritoryDto> newTerritoryList = new ArrayList<>();
        for (TerritoryDto territories : territoryDtoList) {
            TerritoryDto territoryDto = new TerritoryDto();
            newTerritoryList.add(territoryDto.setDescription(territories.getDescription()));
        }
        return newTerritoryList;
    }


}
