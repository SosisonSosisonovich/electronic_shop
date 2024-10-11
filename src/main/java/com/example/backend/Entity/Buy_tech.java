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
    @NonNull
    private Integer buy_tech_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Product product_id;

    @Column(nullable = false)
    @NonNull
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id",nullable = false)
    @NonNull
    private ShoppingCart cart_id;
}
