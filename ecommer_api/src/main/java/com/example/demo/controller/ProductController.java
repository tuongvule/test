package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products/{pageNum}")
    public List <Product> getListProductBySearchAll(@PathVariable int pageNum
            ,@RequestParam String search , @RequestParam int pageSize){
        return productService.getListProduct(search,pageNum ,pageSize);
    }

    @GetMapping("/products2/{pageNum}")
    public List<Product> getAllByProductTypeId(@PathVariable int pageNum
            ,@RequestParam String productTypeId, @RequestParam int pageSize){
        return productService.getAllByProductType(productTypeId, pageNum, pageSize);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/pro")
    public List<Product> findAll(@RequestParam String search ){
        return productService.getListProduct(search,-1, 5);
    }



}
