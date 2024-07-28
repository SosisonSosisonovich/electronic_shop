package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Integer product_id;

    private String name;

    private String description;

    private int amount;

    private String price;

    private int sale;

    private String category_id;
}
