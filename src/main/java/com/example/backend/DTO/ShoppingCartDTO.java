package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDTO { //возможно добавятся доп.классы DTO к корзине

    private Integer cart_id;

    private String customer_id;

    private String buy_tech_id;

    private Long total_count;

}

