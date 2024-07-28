package com.example.backend.Repositories;

import com.example.backend.Entity.Buy_tech;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Buy_TechRepository extends CrudRepository<Buy_tech, Integer> {
}
