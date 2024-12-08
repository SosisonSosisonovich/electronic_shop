package com.example.backend.Controllers;

import com.example.backend.DTO.Cart_ItemDTO;
import com.example.backend.DTO.CategoryDTO;
import com.example.backend.DTO.ProductDTO;
import com.example.backend.DTO.ShoppingCartDTO;
import com.example.backend.Entity.Cart_item;
import com.example.backend.Entity.Customer;
import com.example.backend.Entity.Product;
import com.example.backend.Entity.ShoppingCart;
import com.example.backend.Repositories.ProductRepository;
import com.example.backend.Repositories.Shopping_CartRepository;
import com.example.backend.Services.Cart_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy_tech")
public class Cart_ItemController {
/*
    @Autowired
    private Cart_ItemService cartItemService;

    private ProductRepository productRepository;
    private Shopping_CartRepository cartRepository;

    @GetMapping("/{id}")
    public Cart_ItemDTO getCart_Item(@PathVariable("id") Integer id){
        Cart_item cartItem = (Cart_item) cartItemService.getCart_item(id);

        return convertToDTO(cartItem);
    }

    @GetMapping()
    public Iterable<Cart_item> getAllCart_item(){//подумать
        return cartItemService.getAllCart_item();
    }

    @PostMapping()
    public Cart_item addNewCart_item(@RequestBody Cart_item name){
        return cartItemService.addNewCart_item(name);
    }

    @PutMapping("/{id}")
    public Cart_item updateCart_item(@PathVariable Integer id, @RequestBody Cart_item name){
        name.setCart_item_id(id);
        return cartItemService.addNewCart_item(name);
    }

    @DeleteMapping("/{id}")
    public void deleteCart_item(@PathVariable("id") Integer id){
        cartItemService.deleteCart_item(id);
    }

    private Cart_ItemDTO convertToDTO(Cart_item cartItem) {
        Cart_ItemDTO cart_itemDTO = new Cart_ItemDTO();

        cart_itemDTO.setCart_item_id(cartItem.getCart_item_id());
        cart_itemDTO.setProduct_id(cartItem.getProduct_id().getProduct_id());
        cart_itemDTO.setAmount(cartItem.getAmount());
        cart_itemDTO.setCart_id(cartItem.getCart_id().getCart_id());

        return cart_itemDTO;
    }

    private Cart_item convertToEntity(Cart_ItemDTO cartItemDTO) {
        Cart_item cartItem = new Cart_item();

        cartItem.setCart_item_id(cartItemDTO.getCart_item_id());
        cartItem.setAmount(cartItemDTO.getAmount());

        Product product = productRepository.findById(cartItemDTO.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Продукт не найден."));

        ShoppingCart cart = cartRepository.findById(cartItemDTO.getCart_id())
                .orElseThrow(() -> new RuntimeException("Корзина не найден."));

        cartItem.setProduct_id(product);
        cartItem.setCart_id(cart);

        return cartItem;
    }
*/
}
