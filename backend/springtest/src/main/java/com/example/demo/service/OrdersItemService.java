package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.OrdersItem;
import com.example.demo.respository.OrdersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersItemService {

    @Autowired
    OrdersItemRepository ordersItemRepository;

    @Transactional
    public void insert(OrdersItem ordersItem) {
        ordersItemRepository.save(ordersItem);
    }

    @Transactional
    public OrdersItem getById(Long id) { return ordersItemRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)); }

    @Transactional
    public List<OrdersItem> getAll() {
        return (List<OrdersItem>) ordersItemRepository.findAll();
    }


    @Transactional
    public void updateById(Long Id, OrdersItem ordersItem) {
        OrdersItem existingOrdersItem = ordersItemRepository.findById(Id).orElse(new OrdersItem());
        ordersItem.setId(existingOrdersItem.getId());
        ordersItemRepository.save(ordersItem);
    }

    @Transactional
    public void deleteById(Long id) {
        ordersItemRepository.deleteById(id);
    }

}
