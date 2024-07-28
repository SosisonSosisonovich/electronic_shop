package com.example.backend.Services;

import com.example.backend.Entity.ShoppingCart;
import com.example.backend.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private CartRepository cartRepository;

    public ShoppingCart getCart(Integer id){
        return cartRepository.findById(id).orElse(null);
    }

    public Iterable<ShoppingCart> getAllCarts(){
        return cartRepository.findAll();
    }

    public ShoppingCart addNewShoppingCart(ShoppingCart cart){
        return cartRepository.save(cart);
    }

    public void deleteShoppingCart(Integer id){
        cartRepository.deleteById(id);
    }
}
