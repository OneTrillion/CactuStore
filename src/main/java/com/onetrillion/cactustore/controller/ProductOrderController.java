package com.onetrillion.cactustore.controller;

import com.onetrillion.cactustore.model.ProductOrder;
import com.onetrillion.cactustore.service.ProductOrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/product-orders")
@AllArgsConstructor
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    //TODO: fixa så att, hämta id från namn sen order från userId
    @GetMapping("/product-order-by-username/{username}")
    @PreAuthorize("hasAuthority('customer:read')")
    public Optional<ProductOrder> fetchProductOrderByUserId(){
        return null;
    }
}
