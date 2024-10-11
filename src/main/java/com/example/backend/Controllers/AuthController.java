package com.example.backend.Controllers;

import com.example.backend.Config.JwtAuthenticationResponse;
import com.example.backend.Config.JwtTokenProvider;
import com.example.backend.DTO.LoginRequest;
import com.example.backend.DTO.RegisterRequest;
import com.example.backend.Services.CustomUserDetailsService;
import com.example.backend.Services.CustomerService;
import com.example.backend.Services.CustomerUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final CustomerService customerService;

    private final JwtTokenProvider tokenProvider;


    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider,
                          CustomerService customerService, CustomUserDetailsService customerDetailsService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this. customerService = customerService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            // Создание объекта аутентификации с email и паролем
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            // Успешная аутентификация
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String email = ((CustomerUserDetails) authentication.getPrincipal()).getUsername();
            // Генерация JWT-токена
            String jwtToken = tokenProvider.generateToken(email);

            return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterRequest registerRequest){
        try{
        customerService.addCustomer(registerRequest);
        return  ResponseEntity.ok("Человек зарегестрирован!");
        }catch (Exception e){
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}