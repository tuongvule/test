package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCart;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductCartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductCartServiceImpl implements ProductCartService {
    @Autowired
    ProductCartRepository productCartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Override
    public int addToCart(Long idProduct, Long idCart) {
        ProductCart productCart = new ProductCart();
        Product product = productRepository.findById(idProduct).orElse(null);
        Cart cart = cartRepository.findById(idCart).orElse(null);
        productCart.setDeleted((byte) 0);
        productCart.setQuantity(1);
        productCart.setProduct(product);
        productCart.setCart(cart);
        productCartRepository.save(productCart);
        return 1;
    }

    @Override
    public int updateQuantityProductCart(Long id, Integer quantity) {
        try {
            ProductCart productCart = null;
            productCart = productCartRepository.findById(id).orElse(null);
            if (quantity>1){
                productCart.setQuantity(quantity);
                productCartRepository.save(productCart);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public List<ProductCart> getListProductCart() {
        List<ProductCart> productCartList = null;
        try {
            productCartList = productCartRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        HashSet<ProductCart> set = new HashSet<>();
//        set.addAll(productCartList);
        return  productCartList;
    }

    @Override
    public List<ProductCart> findAllByCart_Id(Long cartId) {
        List<ProductCart> productCartList = null;
        try {
            productCartList =  productCartRepository.findAllByCart_Id(cartId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productCartList;
    }

    @Override
    public int removeListProductCart(Long[] ids) {
        try {
            for (Long id: ids) {
                productCartRepository.deleteById(id);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Long id) {
        try {
            productCartRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
