package com.altuhin.ecommerce.controller;

import com.altuhin.ecommerce.dto.ProductDto;
import com.altuhin.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(ProductDto productDto, Integer id) {
        return productService.updateProduct(productDto, id);
    }

    @PostMapping("/delete/{id}")
    public ProductDto deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

}
