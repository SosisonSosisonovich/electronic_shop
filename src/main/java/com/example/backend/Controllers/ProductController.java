package com.example.backend.Controllers;

import com.example.backend.Entity.Product;
import com.example.backend.Repositories.ProductRepository;
import com.example.backend.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productService.getProduct(id);
    }

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/search/{name}")
    public List<Product> getProductByName(String name){
        return productService.getProduct(name);
    }

    @PostMapping("/new")
    public void addNewProduct(Product name){
        productService.addNewProduct(name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }

}
