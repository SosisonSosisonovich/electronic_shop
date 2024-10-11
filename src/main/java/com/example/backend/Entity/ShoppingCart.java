package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@Data
@NoArgsConstructor(force = true)
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NonNull
    private Integer cart_id;

    @ManyToOne(fetch = FetchType.LAZY) // подумать, мб тут Manytoone
    @JoinColumn(name = "customer_id", nullable = false)
    @NonNull
    private Customer customer_id;

    @OneToMany(mappedBy = "cart_id", fetch = FetchType.LAZY) //тоже подумать
    @NonNull
    private Set<Buy_tech> buy_tech_id;

    @Column(nullable = false)
    @NonNull
    private Long total_count;

}
