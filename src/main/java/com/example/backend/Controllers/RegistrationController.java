package com.example.backend.Controllers;


import com.example.backend.Entity.Customer;
import com.example.backend.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class RegistrationController {
    /*контроллер, который отвечает за регистрацию*/
    @Autowired
    private CustomerService customerService;
    private PasswordEncoder passwordEncoder;

    /*@GetMapping("/registration")
    public void registration(Model model){
        model.addAttribute("userForm", new Customer());
    }*/

    @PostMapping("/registration")
    public boolean addNewCustomer(@RequestBody Customer customer){
        System.out.println("Чувак зареган");
        return customerService.addCustomer(customer);
    }
}
