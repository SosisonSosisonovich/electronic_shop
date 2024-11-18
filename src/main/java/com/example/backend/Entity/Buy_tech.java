package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Buy_tech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer buy_tech_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product_id;

    @Column(nullable = false)
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id",nullable = false)
    private ShoppingCart cart_id;
}
