package com.example.backend.Controllers;

import com.example.backend.DTO.CustomerDTO;
import com.example.backend.Entity.Customer;
import com.example.backend.Mappers.CustomerMappers;
import com.example.backend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMappers customerMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id) {
        Customer customer = (Customer) customerService.getCustomer(id).getBody(); // Предполагается, что Customer возвращается из ResponseEntity
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerMapper.toDTO(customer));
    }

    @GetMapping
    public CustomerDTO getCustomerByName(@RequestParam String name, @RequestParam String surname) {
        Customer customer = customerService.getCustomerByNameAndSurname(name, surname);
        return customerMapper.toDTO(customer);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerService.getAllCustomers();
        return customerMapper.toDTOList(customers);
    }
}
