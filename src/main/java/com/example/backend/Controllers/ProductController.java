package com.example.backend.Controllers;

import com.example.backend.DTO.CategoryDTO;
import com.example.backend.DTO.ProductDTO;
import com.example.backend.Entity.Category;
import com.example.backend.Entity.Product;
import com.example.backend.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*@GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productService.getProductById(id);
    }*/

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Integer id){
        Product product = productService.getProductById(id);

        /*ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(product.getProduct_id());
        productDTO.setName(product.getName());*/

        return convertToDTO(product);
    }

    /*@GetMapping("/{name}")
    public List<Product> getProductByName(String name){
        return productService.getProductByName(name);
    }*/

    @GetMapping("/search/{name}")
    public ProductDTO getProductByName(@PathVariable("name") String name) {
        Product product = productService.getProductByName(name);
        return convertToDTO(product);
    }

   /* @GetMapping
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }*/

    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        List<Product> products = (List<Product>) productService.getAllProducts();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /*@PostMapping("/new")
    public void addNewProduct(Product name){
        productService.addNewProduct(name);
    }*/

    @PostMapping
    public ProductDTO addNewProduct(@RequestBody ProductDTO name){
        Product product = convertToEntity(name);
        Product savedProduct = productService.addNewProduct(product);
        return convertToDTO(savedProduct);
    }

    @PutMapping("/update/{id}")
    public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody ProductDTO name){
        Product product = convertToEntity(name);
        product.setProduct_id(id);
        Product updatedProduct = productService.addNewProduct(product);
        return convertToDTO(updatedProduct);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(product.getProduct_id());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setAmount(product.getAmount());
        productDTO.setPrice(product.getPrice());
        productDTO.setSale(product.getSale());
        productDTO.setCategory_id(product.getCategories());
        return productDTO;
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProduct_id(productDTO.getProduct_id());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setAmount(productDTO.getAmount());
        product.setPrice(productDTO.getPrice());
        product.setSale(productDTO.getSale());
        product.setCategories(productDTO.getCategory_id());
        return product;
    }
}
