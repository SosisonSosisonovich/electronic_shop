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
    @NonNull
    private Integer category_id;

    @Column(name = "category_name", unique = true, nullable = false)
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @NonNull
    private Set<Product> product_id;
}
