package com.altuhin.ecommerce.service.mapper;

import com.altuhin.ecommerce.dto.ProductDto;
import com.altuhin.ecommerce.entity.Category;
import com.altuhin.ecommerce.entity.Product;

public class ProductTransformService {

    /**
     * private Integer unitInStock;
     * private Integer unitOnOrder;
     * private Double unitPrice;
     * private Integer reorderLevel;
     * private Integer discontinued;
     * private String productName;
     * private String quantityPerUnit;
     */

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        return productDto.setProductName(product.getProductName()).setUnitInStock(product.getUnitInStock())
                .setUnitOnOrder(product.getUnitOnOrder()).setUnitPrice(product.getUnitPrice())
                .setReorderLevel(product.getReorderLevel())
                .setDiscontinued(product.getDiscontinued()).setProductName(product.getProductName())
                .setQuantityPerUnit(product.getQuantityPerUnit());
    }


    public static ProductDto mapToProductDto(Product product, ProductDto productDto) {
        return productDto.setProductName(product.getProductName()).setUnitInStock(product.getUnitInStock())
                .setUnitOnOrder(product.getUnitOnOrder()).setUnitPrice(product.getUnitPrice())
                .setReorderLevel(product.getReorderLevel())
                .setDiscontinued(product.getDiscontinued()).setProductName(product.getProductName())
                .setQuantityPerUnit(product.getQuantityPerUnit());
    }

    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        return product.setProductName(productDto.getProductName()).setUnitInStock(productDto.getUnitInStock())
                .setUnitOnOrder(productDto.getUnitOnOrder()).setUnitPrice(productDto.getUnitPrice())
                .setReorderLevel(productDto.getReorderLevel()).setDiscontinued(productDto.getDiscontinued())
                .setProductName(productDto.getProductName()).setQuantityPerUnit(productDto.getQuantityPerUnit());
    }

    public static Product mapToProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        return product.setProductName(productDto.getProductName()).setUnitInStock(productDto.getUnitInStock())
                .setUnitOnOrder(productDto.getUnitOnOrder()).setUnitPrice(productDto.getUnitPrice())
                .setReorderLevel(productDto.getReorderLevel()).setDiscontinued(productDto.getDiscontinued())
                .setProductName(productDto.getProductName()).setQuantityPerUnit(productDto.getQuantityPerUnit());
    }

    public static Product mapToProduct(Product product, ProductDto productDto) {
        return product.setProductName(productDto.getProductName()).setUnitInStock(productDto.getUnitInStock())
                .setUnitOnOrder(productDto.getUnitOnOrder()).setUnitPrice(productDto.getUnitPrice())
                .setReorderLevel(productDto.getReorderLevel()).setDiscontinued(productDto.getDiscontinued())
                .setProductName(productDto.getProductName()).setQuantityPerUnit(productDto.getQuantityPerUnit());
    }
}
