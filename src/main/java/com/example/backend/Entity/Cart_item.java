package com.example.backend.Entity;

import com.example.backend.DTO.Cart_ItemDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
@Data
@NoArgsConstructor(force = true)
public class Cart_item extends Cart_ItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer cart_item_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id",nullable = false)
    private ShoppingCart cart_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product_id;

    @Column(nullable = false)
    private int amount;
}
