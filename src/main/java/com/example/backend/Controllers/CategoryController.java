package com.example.backend.Controllers;

import com.example.backend.Entity.Category;
import com.example.backend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")//указывается, что все методы контроллера относятся к URl-адресы /category
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //получить категорию
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Integer id){
        return categoryService.getCategory(id);
    }

    // получить список всех категорий
    @GetMapping()
    public Iterable<Category> getAllCategories(){//подумать
        return categoryService.getAllCategories();
    }

    //добавить категорию
    @PostMapping()
    public Category addNewCategory(@RequestBody Category name){
        return categoryService.addNewCategory(name);
    }

    //обновить категорию
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category){
        category.setCategory_id(id);
        return categoryService.addNewCategory(category);
    }

    //удалить категорию
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
    }

}
