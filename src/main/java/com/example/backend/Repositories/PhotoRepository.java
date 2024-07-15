package com.example.backend.Repositories;

import com.example.backend.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Category, Integer> {
}
