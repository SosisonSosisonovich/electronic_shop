package com.example.backend.Controllers;

import com.example.backend.Entity.Cart_item;
import com.example.backend.Services.Cart_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy_tech")
public class Cart_ItemController {

    @Autowired
    private Cart_ItemService cartItemService;

    @GetMapping("/{id}")
    public Cart_item getCart_item(@PathVariable("id") Integer id){
        return cartItemService.getCart_item(id);
    }

    // получить список всех категорий
    @GetMapping()
    public Iterable<Cart_item> getAllCart_item(){//подумать
        return cartItemService.getAllCart_item();
    }

    //добавить категорию
    @PostMapping()
    public Cart_item addNewCart_item(@RequestBody Cart_item name){
        return cartItemService.addNewCart_item(name);
    }

    //обновить категорию
    @PutMapping("/{id}")
    public Cart_item updateCart_item(@PathVariable Integer id, @RequestBody Cart_item name){
        name.setCart_item_id(id);
        return cartItemService.addNewCart_item(name);
    }

    //удалить категорию
    @DeleteMapping("/{id}")
    public void deleteCart_item(@PathVariable("id") Integer id){
        cartItemService.deleteCart_item(id);
    }

}
