package com.example.backend.Controllers;


import com.example.backend.Entity.Customer;
import com.example.backend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public boolean addNewCustomer(@RequestBody Customer customer){
        System.out.println("Чувак зареган");
        return customerService.addCustomer(customer);
    }
}
