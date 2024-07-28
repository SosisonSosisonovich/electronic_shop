package com.example.backend.Controllers;

import com.example.backend.Entity.Buy_tech;
import com.example.backend.Services.Buy_TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy_tech")
public class Buy_TechController {

    @Autowired
    private Buy_TechService buyTechService;

    @GetMapping("/{id}")
    public Buy_tech getCategory(@PathVariable("id") Integer id){
        return buyTechService.getBuy_Tech(id);
    }

    // получить список всех категорий
    @GetMapping()
    public Iterable<Buy_tech> getAllCategories(){//подумать
        return buyTechService.getAllBuy_Tech();
    }

    //добавить категорию
    @PostMapping()
    public Buy_tech addNewCategory(@RequestBody Buy_tech name){
        return buyTechService.addNewBuy_Tech(name);
    }

    //обновить категорию
    @PutMapping("/{id}")
    public Buy_tech updateCategory(@PathVariable Integer id, @RequestBody Buy_tech name){
        name.setBuy_tech_id(id);
        return buyTechService.addNewBuy_Tech(name);
    }

    //удалить категорию
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        buyTechService.deleteBuy_Tech(id);
    }

}
