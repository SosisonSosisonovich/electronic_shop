package com.example.backend.Controllers;

import com.example.backend.Entity.ShoppingCart;
import com.example.backend.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //получить корзину по айди
    @GetMapping("/{id}")
    public ShoppingCart getCart(@PathVariable("id") Integer id){
        return shoppingCartService.getCart(id);
    }

    //получить все корзины
    @GetMapping
    public Iterable<ShoppingCart> getAllCarts(){//подумать
        return shoppingCartService.getAllCarts();
    }

    //добавить новую корзину
    @PostMapping
    public ShoppingCart addNewCart(@RequestBody ShoppingCart name){
        return shoppingCartService.addNewShoppingCart(name);
    }

    //обновить корзину
    @PutMapping("/{id}")
    public ShoppingCart updateCart(@PathVariable Integer id, @RequestBody ShoppingCart cart){
        cart.setCart_id(id);
        return shoppingCartService.addNewShoppingCart(cart);
    }

    //удалить корзину
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Integer id){
        shoppingCartService.deleteShoppingCart(id);
    }

}
