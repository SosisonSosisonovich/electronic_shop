package com.example.backend.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)//возможно нужно будет удалить
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    @NonNull
    private Integer id;

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
    //@Setter(AccessLevel.PROTECTED)
    @NonNull
    private String password;

   /* @Transient
    private String passwordConfirm;*/

    @OneToMany(mappedBy = "cart_id", fetch = FetchType.LAZY)
    private Set<ShoppingCart> shoppingCarts;


}
