package com.example.backend.Services;


import com.example.backend.Entity.Cart_item;
import com.example.backend.Repositories.Cart_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cart_ItemService {

    @Autowired
    private Cart_ItemRepository cartItemRepository;

    public Cart_item getCart_item(Integer id){
        return cartItemRepository.findById(id).orElse(null);
    }

    public Iterable<Cart_item> getAllCart_item(){
        return cartItemRepository.findAll();
    }

    public Cart_item addNewCart_item(Cart_item cart){
        return cartItemRepository.save(cart);
    }

    public void deleteCart_item(Integer id){
        cartItemRepository.deleteById(id);
    }
}
