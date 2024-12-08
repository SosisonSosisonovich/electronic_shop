package com.example.backend.Controllers;


import com.example.backend.DTO.ProductDTO;
import com.example.backend.DTO.ShoppingCartDTO;
import com.example.backend.Entity.Customer;
import com.example.backend.Entity.ShoppingCart;
import com.example.backend.Repositories.CustomerRepository;
import com.example.backend.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
/*
    @Autowired
    private ShoppingCartService cartService;

    private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public ShoppingCartDTO getCart(@PathVariable("id") Integer id){
        ShoppingCart cart = cartService.getCart(id);

        return convertToDTO(cart);
    }

    @GetMapping()
    public List<ShoppingCartDTO> getAllCart(){
        List<ShoppingCart> carts = (List<ShoppingCart>) cartService.getAllCarts();
        return carts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ShoppingCartDTO addNewCart(@RequestBody ShoppingCartDTO name){
        ShoppingCart cart = convertToEntity(name);
        ShoppingCart savedCart = cartService.addNewShoppingCart(cart);

        return convertToDTO(savedCart);
    }

    @PutMapping("/update/{id}")
    public void deleteCart(@PathVariable("id") Integer id){
        cartService.deleteShoppingCart(id);
    }

    private ShoppingCartDTO convertToDTO(ShoppingCart cart) {
        ShoppingCartDTO cartDTO = new ShoppingCartDTO();

        cartDTO.setCart_id(cart.getCart_id());
        cartDTO.setCustomer_id(cart.getCustomer_id().getId());
        cartDTO.setTotal_price(cart.getTotal_price());
        return cartDTO;
    }

    private ShoppingCart convertToEntity(ShoppingCartDTO cartDTO) {
        ShoppingCart cart = new ShoppingCart();

        cart.setCart_id(cartDTO.getCart_id());
        cart.setTotal_price(cartDTO.getTotal_price());


        Customer customer = customerRepository.findById(cartDTO.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Покупатель не найден."));

        cart.setCustomer_id(customer);
        return cart;
    }
*/
}
