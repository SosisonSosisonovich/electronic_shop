package com.example.backend.Services;

import com.example.backend.Entity.Customer;
import com.example.backend.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<?> getCustomer(Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public ResponseEntity<Customer> getAllCustomers(){ //подумать
        Iterable<Customer> customer = customerRepository.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public Customer addNewCustomer(Customer name){
        return customerRepository.save(name);
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }
}
