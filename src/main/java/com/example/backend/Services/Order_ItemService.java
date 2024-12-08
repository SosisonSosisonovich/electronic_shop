package com.example.backend.Services;

import com.example.backend.Entity.Order_item;
import com.example.backend.Repositories.Order_ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order_ItemService {

    @Autowired
    private Order_ItemRepository orderItemRepository;

    public Order_item getOrder_Item(Integer id){
        return orderItemRepository.findById(id).orElseThrow(null);
    }

    public Iterable<Order_item> getAllOrders_Item(){
        return orderItemRepository.findAll();
    }

    public Order_item addNewOrder_item(Order_item order_item){
        return orderItemRepository.save(order_item);
    }

    public void deleteOrder_item(Integer id){
        orderItemRepository.deleteById(id);
    }

}
