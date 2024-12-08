package com.example.backend.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor(force = true)
public class Order_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer order_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order_id;

    @Column(nullable = false)
    private int amount;

}
