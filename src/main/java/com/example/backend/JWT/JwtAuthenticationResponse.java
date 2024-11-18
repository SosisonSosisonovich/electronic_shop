package com.example.backend.JWT;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthenticationResponse {

    private String accessToken; // хранит в себе jwt-токен, нужен для использования защищенных эндпоинтов
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
