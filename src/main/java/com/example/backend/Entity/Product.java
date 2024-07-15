package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
/*@Getter//через lombok = public Long getId(){return id}
@Setter//через lombok = public Long setId(Long id){this.id = id}
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@NoArgsConstructor//возможно нужно будет удалить
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @NonNull
    private Integer product_id;

    @Column(nullable = false)
    @NonNull
    private String product_name;

    @Column(nullable = false, length = 500)
    @NonNull
    private String description;

    @Column(nullable = false)
    @NonNull
    private int amount;

    @Column(nullable = false)
    @NonNull
    private String price;

    @Column(nullable = false)
    @NonNull
    private int sale;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_product",
     joinColumns = @JoinColumn(name = "product_id"),
     inverseJoinColumns = @JoinColumn(name = "category_id"))
    @NonNull
    private Set<Category> categories;

    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY)
    private Set<Photo> photo_id;
}
