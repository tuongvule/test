package com.example.demo.service;

import com.example.demo.model.Cart;

import java.util.List;

public interface CartService {
    int addCart(Cart cart);
    List<Cart> getListCart();
}
