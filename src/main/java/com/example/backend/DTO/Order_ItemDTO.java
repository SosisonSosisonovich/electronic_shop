package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order_ItemDTO {

    private Integer order_item_id;

    private Integer order_id;

    private Integer product_id;

    private int amount;
}
