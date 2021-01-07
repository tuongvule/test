package com.example.demo.service.impl;

import com.example.demo.model.ProductType;
import com.example.demo.repository.ProductTypeRepository;
import com.example.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> getListProductType() {
        List<ProductType> productTypeList = null;
        try {
            productTypeList = productTypeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypeList;
    }
}
