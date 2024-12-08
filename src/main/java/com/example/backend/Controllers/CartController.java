package com.example.backend.Controllers;

import com.example.backend.DTO.ShoppingCartDTO;
import com.example.backend.Entity.Customer;
import com.example.backend.Entity.ShoppingCart;
import com.example.backend.Repositories.CustomerRepository;
import com.example.backend.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    private CustomerRepository customerRepository;

    //получить корзину по айди
   /* @GetMapping("/{id}")
    public ShoppingCart getCart(@PathVariable("id") Integer id){
        return shoppingCartService.getCart(id);
    }*/

    @GetMapping("/{id}")
    public ShoppingCartDTO getCart(@PathVariable("id") Integer id){
        ShoppingCart cart = shoppingCartService.getCart(id);

        return convertToDTO(cart);
    }

    //получить все корзины
    /*@GetMapping
    public Iterable<ShoppingCart> getAllCarts(){//подумать
        return shoppingCartService.getAllCarts();
    }*/



    //добавить новую корзину
    /*@PostMapping
    public ShoppingCart addNewCart(@RequestBody ShoppingCart name){
        return shoppingCartService.addNewShoppingCart(name);
    }*/

    //обновить корзину
    /*@PutMapping("/update/{id}")
    public ShoppingCart updateCart(@PathVariable Integer id, @RequestBody ShoppingCart cart){
        cart.setCart_id(id);
        return shoppingCartService.addNewShoppingCart(cart);
    }*/
    @PutMapping("/update/{id}")
    public ShoppingCartDTO updateCart(@PathVariable Integer id, @RequestBody ShoppingCartDTO cartDTO){
        ShoppingCart cart = convertToEntity(cartDTO);
        cart.setCart_id(id);
        ShoppingCart updatedCart = shoppingCartService.addNewShoppingCart(cart);

        return convertToDTO(updatedCart);
    }

    //удалить корзину
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Integer id){
        shoppingCartService.deleteShoppingCart(id);
    }


    private ShoppingCartDTO convertToDTO(ShoppingCart shoppingCart) {
        ShoppingCartDTO cartDTO = new ShoppingCartDTO();

        cartDTO.setCart_id(shoppingCart.getCart_id());
        cartDTO.setCustomer_id(shoppingCart.getCustomer_id().getId());
        cartDTO.setTotal_price(shoppingCart.getTotal_price());

        return cartDTO;
    }

    private ShoppingCart convertToEntity(ShoppingCartDTO cartDTO) {

        ShoppingCart cart = new ShoppingCart();

        cart.setCart_id(cartDTO.getCart_id());
        cart.setTotal_price(cartDTO.getTotal_price());
        Customer customer = customerRepository.findById(cartDTO.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден."));

        cart.setCustomer_id(customer);

        return cart;
    }

}
