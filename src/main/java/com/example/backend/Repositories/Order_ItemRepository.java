package com.example.backend.Repositories;

import com.example.backend.Entity.Order_item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_ItemRepository extends CrudRepository<Order_item, Integer> {
}
