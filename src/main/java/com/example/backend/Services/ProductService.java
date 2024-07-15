package com.example.backend.Services;

import com.example.backend.Entity.Product;
import com.example.backend.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<Product> getAllProducts(){//подумать
        return productRepository.findAll();
    }
    public Product addNewProduct(Product name){
        return productRepository.save(name);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
