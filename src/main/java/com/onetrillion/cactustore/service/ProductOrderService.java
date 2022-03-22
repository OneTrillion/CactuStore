package com.onetrillion.cactustore.service;

import com.onetrillion.cactustore.model.ProductOrder;
import com.onetrillion.cactustore.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ProductOrderService {

    private ProductOrderRepository productOrderRepository;

    public Optional<ProductOrder> getProductOrderByUserId(Long userId) {
        return productOrderRepository.findProductOrderByUserId(userId);
    }
}
