package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List <Product> getListProduct(String search, int pageNum, int pageSize) {
        List <Product> products = null;
    try {
        if (pageNum == -1){
            products = productRepository.getListProductBySearchAll(search).stream()
                    .collect(Collectors.toList());
        } else {
            products = productRepository.getListProductBySearchAll(search).stream()
                    .skip((pageNum - 1) * pageSize).limit(pageSize)
                    .collect(Collectors.toList());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return products;
    }

    @Override
    public List<Product> getAllByProductType(String productTypeId, int pageNum, int pageSize) {
        List <Product> products = null;
        try {
            if (pageNum == -1){
                products = productRepository.getAllByProductType(productTypeId).stream()
                        .collect(Collectors.toList());
            } else {
                products = productRepository.getAllByProductType(productTypeId).stream()
                        .skip((pageNum - 1) * pageSize).limit(pageSize)
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = null;
        try {
            product = productRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public int save(Product product) {
        productRepository.save(product);
        return 1;
    }

    @Override
    public int delete(Product product) {
        productRepository.delete(product);
        return 1;
    }

    @Override
    public int update(Product product) {
        productRepository.save(product);
        return 1;
    }


}
