package com.example.backend.Controllers;

import com.example.backend.Entity.Customer;
import com.example.backend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //put, post, delete, get <-- команды запросов

    //@ResponseBody
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomer(id);
    }

    @GetMapping
    public Customer getCustomerByName(@RequestParam String name, @RequestParam String surname){
        return customerService.getCustomerByNameAndSurname(name, surname);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
