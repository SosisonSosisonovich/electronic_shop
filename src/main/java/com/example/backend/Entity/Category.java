package com.example.backend.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor(force = true)//возможно нужно будет удалить
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer category_id;

    @Column(name = "category_name", unique = true)
    private String name;

    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Product> product_id;
}
