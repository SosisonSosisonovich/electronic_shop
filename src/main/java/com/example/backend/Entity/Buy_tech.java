package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
/*@Table(name = "buy_tech")
@Getter//через lombok = public Long getId(){return id}
@Setter//через lombok = public Long setId(Long id){this.id = id}
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@NoArgsConstructor//возможно нужно будет удалить
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
