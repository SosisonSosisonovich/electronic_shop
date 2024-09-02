package com.example.backend.Services;

import com.example.backend.Config.SecurityConfig;
import com.example.backend.Entity.Customer;
import com.example.backend.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> getCustomer(Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public Customer getCustomerByNameAndSurname(String name, String surname){
        return customerRepository.findByNameAndSurname(name, surname);
    }

    public ResponseEntity<Customer> getAllCustomers(){ //подумать
        Iterable<Customer> customer = customerRepository.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean addCustomer(Customer newCustomer){
        Customer customer = customerRepository.findByEmail(newCustomer.getEmail());

        if (customer != null){
            System.out.println("чувак уже есть!");
            return false;
        }
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));

        customerRepository.save(newCustomer);
        return true;
    }

    public boolean deleteCustomer(Integer id){
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return customer;
    }
}
