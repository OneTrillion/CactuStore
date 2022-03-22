package com.onetrillion.cactustore.repository;

import com.onetrillion.cactustore.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    Optional<ProductOrder> findProductOrderByUserId(Long userId);
}
