package com.example.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderDTO {

    private Integer order_id;

    private Integer customer_id;

    private BigDecimal total_price;
}
