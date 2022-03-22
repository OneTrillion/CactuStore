package com.onetrillion.cactustore.controller;

import com.onetrillion.cactustore.model.Product;
import com.onetrillion.cactustore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product-by-name/{productName}")
    public Optional<Product> fetchProductByName(@PathVariable String productName){
        return productService.getProductByName(productName);
    }
}
