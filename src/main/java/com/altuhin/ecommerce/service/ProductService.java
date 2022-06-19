package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.ProductDto;
import com.altuhin.ecommerce.entity.Category;
import com.altuhin.ecommerce.entity.Product;
import com.altuhin.ecommerce.reporsitory.CategoryRepository;
import com.altuhin.ecommerce.reporsitory.ProductRepository;
import com.altuhin.ecommerce.service.mapper.ProductTransformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductDto saveProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(
                () -> new EntityNotFoundException("Category With This Id is not Found!")
        );
        Product savedProduct = productRepository.save(ProductTransformService.mapToProduct(productDto, category));
        return ProductTransformService.mapToProductDto(savedProduct);
    }

    public ProductDto updateProduct(ProductDto productDto, Integer id) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product With This Id is not Found!")
        );
        Product savedProduct = productRepository.save(ProductTransformService.mapToProduct(product, productDto));
        return ProductTransformService.mapToProductDto(savedProduct);
    }

    public ProductDto deleteProduct(ProductDto productDto, Integer id) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product With This Id is not Found!")
        );
        product.setDelete(ApplicationUtility.PRODUCT_DELETED);
        Product savedProduct = productRepository.save(product);
        return ProductTransformService.mapToProductDto(savedProduct);
    }
}
