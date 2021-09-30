package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Orders;
import com.example.demo.respository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Transactional
    public void insert(Orders orders) {
        ordersRepository.save(orders);
    }

    @Transactional
    public Orders getById(Long id) { return ordersRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)); }

    @Transactional
    public List<Orders> getAll() {
        return (List<Orders>) ordersRepository.findAll();
    }


    @Transactional
    public void updateById(Long Id, Orders orders) {
        Orders existingOrders = ordersRepository.findById(Id).orElse(new Orders());
        orders.setId(existingOrders.getId());
        ordersRepository.save(orders);
    }

    @Transactional
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }

}
