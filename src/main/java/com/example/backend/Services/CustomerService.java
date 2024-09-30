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
public class CustomerService{

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

    public Iterable<Customer> getAllCustomers(){ //подумать
        return customerRepository.findAll();
    }

    public boolean addCustomer(Customer newCustomer){
        Customer customer = customerRepository.findByEmail(newCustomer.getEmail());

        if (customer != null){
            System.out.println("чувак уже есть!");
            return false;
        }
        customer.setPassword(customer.getPassword());

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
}
