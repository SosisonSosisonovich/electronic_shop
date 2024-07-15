package com.example.backend.Services;


import com.example.backend.Entity.Buy_tech;
import com.example.backend.Repositories.Buy_TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Buy_TechService {

    @Autowired
    private Buy_TechRepository buyTechRepository;

    public Buy_tech getBuy_Tech(Integer id){
        return buyTechRepository.findById(id).orElse(null);
    }

    public Iterable<Buy_tech> getAllBuy_Tech(){
        return buyTechRepository.findAll();
    }

    public Buy_tech addNewBuy_Tech(Buy_tech cart){
        return buyTechRepository.save(cart);
    }

    public void deleteBuy_Tech(Integer id){
        buyTechRepository.deleteById(id);
    }
}
