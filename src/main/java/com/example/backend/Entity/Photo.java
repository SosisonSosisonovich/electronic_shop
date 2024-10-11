package com.example.backend.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Data
@NoArgsConstructor(force = true)//возможно нужно будет удалить
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @NonNull
    private Integer photo_id;

    @Column(unique = true, nullable = false, length = 500)
    @NonNull
    private String url;

    @ManyToOne(fetch = FetchType.LAZY) //подумать
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @NonNull
    private Product product_id;
}
