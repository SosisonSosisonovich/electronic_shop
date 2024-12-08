package com.example.backend.Controllers;

import com.example.backend.DTO.CategoryDTO;
import com.example.backend.Entity.Category;
import com.example.backend.Mappers.CategoryMappers;
import com.example.backend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")//указывается, что все методы контроллера относятся к URl-адресы /category
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMappers categoryMappers;

    //получить категорию
    /*@GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Integer id){
        return categoryService.getCategory(id);
    } */

    @GetMapping("/search/{name}")
    public CategoryDTO getCategoryByName(@PathVariable("name") String name) {
        Category category = categoryService.getCategoryByName(name);
        return categoryMappers.toDTO(category);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategory(@PathVariable("id") Integer id){
        Category category = categoryService.getCategory(id);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory_id(category.getCategory_id());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    /*// получить список всех категорий
    @GetMapping()
    public Iterable<Category> getAllCategories(){//подумать
        return categoryService.getAllCategories();
    }*/
    @GetMapping()
    public List<CategoryDTO> getAllCategories(){
        List<Category> categories = (List<Category>) categoryService.getAllCategories();
        return categoryMappers.toDTOList(categories);
    }


    //добавить категорию
    /*@PostMapping()
    public Category addNewCategory(@RequestBody Category name){
        return categoryService.addNewCategory(name);
    }*/

    @PostMapping
    public CategoryDTO addNewCateegory(@RequestBody CategoryDTO name){
        Category category = categoryMappers.toEntity(name);
        Category savedCategory = categoryService.addNewCategory(category);
        return categoryMappers.toDTO(savedCategory);
    }

    /*//обновить категорию
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category){
        category.setCategory_id(id);
        return categoryService.addNewCategory(category);
    }*/

    @PutMapping("/update/{id}")
    public CategoryDTO updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO name){
        Category category = categoryMappers.toEntity(name);
        category.setCategory_id(id);
        Category updatedCategory = categoryService.addNewCategory(category);
        return categoryMappers.toDTO(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable("id") Integer id){
        categoryService.deleteCategoryById(id);
    }

   /* private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory_id(category.getCategory_id());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_id(categoryDTO.getCategory_id());
        category.setName(categoryDTO.getName());
        return category;
    }*/

}
