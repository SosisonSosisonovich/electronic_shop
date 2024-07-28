package com.example.backend.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
/*@Getter//через lombok = public Long getId(){return id}
@Setter//через lombok = public Long setId(Long id){this.id = id}
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@NoArgsConstructor//возможно нужно будет удалить
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @NonNull
    private Integer category_id;

    @Column(unique = true, nullable = false)
    @NonNull
    private String name_category;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @NonNull
    private Set<Product> product_id;
}
