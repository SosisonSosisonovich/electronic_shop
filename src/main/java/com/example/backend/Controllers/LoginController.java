package com.example.backend.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public void loginPost(
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ){
        boolean logIn = false;


    }
}
