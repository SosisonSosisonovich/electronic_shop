package com.example.backend.Controllers;

import com.example.backend.DTO.CustomerDTO;
import com.example.backend.Entity.Customer;
import com.example.backend.Repositories.CustomerRepository;
import com.example.backend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //put, post, delete, get <-- команды запросов
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomer(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //На случай ручного добавления пользователя
    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer){
        return addNewCustomer(customer);
    }
}
