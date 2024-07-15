package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
/*@Getter//через lombok = public Long getId(){return id}
@Setter//через lombok = public Long setId(Long id){this.id = id}
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@NoArgsConstructor//возможно нужно будет удалить
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @NonNull
    private Integer customer_id;

    @Column(nullable = false, length = 50)
    @NonNull
    private String name;

    @Column(nullable = false, length = 50)
    @NonNull
    private String surname;

    @Column(unique = true, nullable = false, length = 100)
    @NonNull
    private String email;

    @Column(nullable = false)
    @Setter(AccessLevel.PROTECTED)
    @NonNull
    private String password;

    @OneToMany(mappedBy = "cart_id", fetch = FetchType.LAZY)
    private Set<ShoppingCart> shoppingCarts;

}
