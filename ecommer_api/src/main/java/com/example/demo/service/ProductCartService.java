package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ProductCart;



public interface ProductCartService {
   int addToCart(Long idProduct, Long idCart);
   int updateQuantityProductCart(Long id,Integer quantity);
   List<ProductCart> getListProductCart();
   List<ProductCart> findAllByCart_Id(Long cartId);
   int removeListProductCart(Long[] ids);
   int delete(Long id);
}
