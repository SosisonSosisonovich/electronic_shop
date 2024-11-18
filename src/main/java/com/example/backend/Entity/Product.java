package com.example.backend.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor(force = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer product_id;

    @Column(name = "product_name")
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int sale;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_product",
     joinColumns = @JoinColumn(name = "product_id"),
     inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories; */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category categories;

    private String imageUrl;
}
