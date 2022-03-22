package com.onetrillion.cactustore.service;

import com.onetrillion.cactustore.model.Product;
import com.onetrillion.cactustore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> getProductByName(String productName) {
        return productRepository.findProductByProductName(productName);
    }
}
