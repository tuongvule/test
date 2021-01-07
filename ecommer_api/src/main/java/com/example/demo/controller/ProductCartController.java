package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCart;
import com.example.demo.repository.ProductCartRepository;
import com.example.demo.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductCartController {
    @Autowired
    ProductCartService productCartService;

    @GetMapping("/addToCart")
    public int addToCart(@RequestParam Long idCart, @RequestParam Long idProduct){
        return productCartService.addToCart(idProduct,idCart);
    }

    @GetMapping("/productCartList")
    public List<ProductCart> getListProductCart(){
        return productCartService.getListProductCart();
    }

    @GetMapping("/productCart-byCartId/{cartId}")
    public List<ProductCart> getListProductCartByCartId(@PathVariable Long cartId){
        return productCartService.findAllByCart_Id(cartId);
    }

    @DeleteMapping("/removeListProductCart")
    public int removeListProductCart(@RequestBody Long[] ids){
        return productCartService.removeListProductCart(ids);
    }

    @DeleteMapping("/deleteProductCart/{idProductCart}")
    public int deleteProductCart(@PathVariable Long idProductCart){
        return productCartService.delete(idProductCart);
    }

    @GetMapping("/updateQuantityProductCart/{id}")
    public int updateQuantityProductCart(@PathVariable Long id, @RequestParam Integer quantity){
        return productCartService.updateQuantityProductCart(id, quantity);
    }
}
