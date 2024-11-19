package com.example.backend.Repositories;

import com.example.backend.Entity.Cart_item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_ItemRepository extends CrudRepository<Cart_item, Integer> {
}
