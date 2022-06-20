package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.RegionDto;
import com.altuhin.ecommerce.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @PostMapping("/save")
    public RegionDto saveRegion(@RequestBody RegionDto regionDto) {
        return regionService.saveRegion(regionDto);
    }


}
