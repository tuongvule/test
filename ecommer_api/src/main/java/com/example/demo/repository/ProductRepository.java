package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value="select * from product where `name` like %?1% or price like %?1% or trade_mark like %?1%", nativeQuery = true)
    List <Product> getListProductBySearchAll(String search);
    @Query(value= "SELECT * FROM product where product_type_id like %?1%", nativeQuery = true)
    List <Product> getAllByProductType(String productTypeId);
}
