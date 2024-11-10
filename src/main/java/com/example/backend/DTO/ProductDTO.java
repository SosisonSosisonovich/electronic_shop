package com.example.backend.DTO;

import com.example.backend.Entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductDTO {

    private Integer product_id;

    private String name;

    private String description;

    private int amount;

    private int price;

    private int sale;

    //private Set<Category> category_id;

    private Integer category_id;
}
