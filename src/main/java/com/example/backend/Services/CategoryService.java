package com.example.backend.Services;

import com.example.backend.Entity.Category;
import com.example.backend.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name)
                .orElseThrow(()-> new IllegalArgumentException("Категория с именем " + name + " не найдена"));

    }

    public Iterable<Category> getAllCategories(){//подумать
        return categoryRepository.findAll();
    }

    public Category addNewCategory(Category name){
        return categoryRepository.save(name);
    }

    public void deleteCategoryById(Integer id){
        categoryRepository.deleteById(id);
    }
}
