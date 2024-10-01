package com.example.backend.Services;


import com.example.backend.DTO.RegisterRequest;
import com.example.backend.Entity.Customer;
import com.example.backend.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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

    /*public boolean addCustomer(RegisterRequest newCustomer){
        Customer customer = customerRepository.findByEmail(newCustomer.getEmail());

        if (customer != null){
            System.out.println("чувак уже есть!");
            return false;
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        customerRepository.save(newCustomer);
        return true;
    }*/

    public Customer addCustomer(RegisterRequest registerRequest){
        if(customerRepository.existsByEmail(registerRequest.getEmail())){
            throw new IllegalArgumentException();
        }

        Customer customer = new Customer();
        customer.setName(registerRequest.getName());
        customer.setSurname(registerRequest.getSurname());
        customer.setEmail(registerRequest.getEmail());
        customer.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(Integer id){
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
