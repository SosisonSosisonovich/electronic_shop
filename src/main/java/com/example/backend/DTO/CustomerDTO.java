package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Integer customer_id;

    private String name;

    private String surname;

    private String email;

    private String password;
}
