package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.CategoryDto;
import com.altuhin.ecommerce.entity.Category;
import com.altuhin.ecommerce.reporsitory.CategoryRepository;
import com.altuhin.ecommerce.service.mapper.CategoryTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category saveCategory = categoryRepository.save(CategoryTransformService.mapToCategory(categoryDto));
        return CategoryTransformService.mapToCategoryDto(saveCategory);
    }

    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category With This Id is not Found!")
        );
        Category saveCategory = categoryRepository.save(CategoryTransformService.mapToCategory(category, categoryDto));
        return CategoryTransformService.mapToCategoryDto(saveCategory);
    }

    public CategoryDto deleteCategory(Integer id) {


        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category With This Id is not Found!")
        );
        category.setDelete(ApplicationUtility.CATEGORY_DELETED);
        return CategoryTransformService.mapToCategoryDto(categoryRepository.save(category));
    }
}
