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

    private int price;

    private int sale;

    private Integer category_id;

    private String imageUrl;
}
