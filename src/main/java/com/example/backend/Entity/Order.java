package com.example.backend.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor(force = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    private BigDecimal total_price;
}
