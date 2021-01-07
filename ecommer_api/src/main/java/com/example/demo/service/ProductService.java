package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;


public interface ProductService {
    List <Product> getListProduct(String search, int pageNum, int pageSize);
    List <Product> getAllByProductType(String productTypeId, int pageNum, int pageSize);
    Product getProductById(Long id);
    List<Product> findAll();
    int save(Product product);
    int delete(Product product);
    int update(Product product);
}
