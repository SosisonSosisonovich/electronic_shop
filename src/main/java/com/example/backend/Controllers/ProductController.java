package com.example.backend.Controllers;

import com.example.backend.Entity.Product;
import com.example.backend.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Integer id){
        return productRepository.findById(id);
    }

    @GetMapping()
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/new")
    public void addNewProduct(Product name){
        productRepository.save(name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
    }

}
