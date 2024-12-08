package com.example.backend.Repositories;

import com.example.backend.Entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Shopping_CartRepository extends CrudRepository<ShoppingCart, Integer> {
}
