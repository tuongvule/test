package com.example.demo.repository;

import com.example.demo.model.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findAllByCart_Id(Long cartId);
}
