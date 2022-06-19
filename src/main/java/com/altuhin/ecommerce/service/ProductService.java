package com.altuhin.ecommerce.service;

import com.altuhin.ecommerce.ApplicationUtility;
import com.altuhin.ecommerce.dto.ProductDto;
import com.altuhin.ecommerce.dto.projection.EmployeeOrderDetailsProjection;
import com.altuhin.ecommerce.entity.Category;
import com.altuhin.ecommerce.entity.Product;
import com.altuhin.ecommerce.entity.QCustomer;
import com.altuhin.ecommerce.entity.QOrder;
import com.altuhin.ecommerce.entity.QOrderDetails;
import com.altuhin.ecommerce.entity.QProduct;
import com.altuhin.ecommerce.reporsitory.CategoryRepository;
import com.altuhin.ecommerce.reporsitory.CustomerRepository;
import com.altuhin.ecommerce.reporsitory.OrderDetailsRepository;
import com.altuhin.ecommerce.reporsitory.OrderRepository;
import com.altuhin.ecommerce.reporsitory.ProductRepository;
import com.altuhin.ecommerce.service.mapper.ProductTransformService;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;


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

    public ProductDto deleteProduct(Integer id) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product With This Id is not Found!")
        );
        product.setDelete(ApplicationUtility.PRODUCT_DELETED);
        Product savedProduct = productRepository.save(product);
        return ProductTransformService.mapToProductDto(savedProduct);
    }

    public List<EmployeeOrderDetailsProjection> getEmployeeOrderDetailsData() {
        QProduct qProduct = QProduct.product;
        QOrderDetails qOrderDetails = QOrderDetails.orderDetails;
        QOrder qOrder = QOrder.order;
        QCustomer qCustomer = QCustomer.customer;

        JPAQuery<Product> query = new JPAQuery<>();

        JPAQuery<Tuple> select = query.from(qProduct).leftJoin(qProduct.orderDetailsList, qOrderDetails).innerJoin(qOrderDetails.order, qOrder)
                .select(qCustomer.address, qCustomer.contactName);


        return null;
    }
}
