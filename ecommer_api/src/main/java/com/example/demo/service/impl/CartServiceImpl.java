package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Override
    public int addCart(Cart cart) {
        cartRepository.save(cart);
        return 1;
    }

    @Override
    public List<Cart> getListCart() {
        return cartRepository.findAll();
    }
}
