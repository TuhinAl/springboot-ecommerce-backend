package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.dto.TerritoryDto;
import com.altuhin.ecommerce.entity.QRegion;
import com.altuhin.ecommerce.entity.QTerritory;
import com.altuhin.ecommerce.entity.Region;
import com.altuhin.ecommerce.entity.Territory;
import com.altuhin.ecommerce.service.mapper.TerritoryTransformService;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TerritoryService {

    private final EntityManager entityManager;

    public List<TerritoryDto> getTerritoryLeftRegionData() {

        final QRegion qRegion = QRegion.region;
        final QTerritory qTerritory = QTerritory.territory;
        JPAQuery<Region> regionJPAQuery = new JPAQuery<>();
        JPAQuery<Territory> territoryJPAQuery = new JPAQuery<>(entityManager);
        List<Territory> territoryWithRegionList = territoryJPAQuery.from(qTerritory).leftJoin(qTerritory.region, qRegion).fetch();
        return TerritoryTransformService.mapToTerritoryDto(territoryWithRegionList);
    }
}
