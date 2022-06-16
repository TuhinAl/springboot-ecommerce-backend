package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.CategoryDto;
import com.altuhin.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

}
