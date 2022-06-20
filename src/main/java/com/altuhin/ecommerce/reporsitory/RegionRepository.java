package com.altuhin.ecommerce.reporsitory;

import com.altuhin.ecommerce.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}