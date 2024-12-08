package com.example.backend.Services;

import com.example.backend.Entity.Order;
import com.example.backend.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Integer id){
        return orderRepository.findById(id).orElseThrow(null);
    }

    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order addNewOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
}
