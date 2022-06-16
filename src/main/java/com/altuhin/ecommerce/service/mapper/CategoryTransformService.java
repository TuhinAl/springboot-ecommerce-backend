package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.CategoryDto;
import com.altuhin.ecommerce.entity.Category;

public class CategoryTransformService {

    public static CategoryDto mapToCategoryDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();
        return categoryDto.setCategoryName(category.getCategoryName()).setDescription(category.getDescription());
    }

    public static CategoryDto mapToCategoryDto(Category category, CategoryDto categoryDto) {
        return categoryDto.setCategoryName(category.getCategoryName()).setDescription(category.getDescription());
    }

    public static Category mapToCategory(CategoryDto categoryDto) {

        Category category = new Category();
        return category.setCategoryName(categoryDto.getCategoryName()).setDescription(categoryDto.getDescription());
    }

    public static Category mapToCategory(Category category, CategoryDto categoryDto) {
        return category.setCategoryName(categoryDto.getCategoryName()).setDescription(categoryDto.getDescription());
    }
}
