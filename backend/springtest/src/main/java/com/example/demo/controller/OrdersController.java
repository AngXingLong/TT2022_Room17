package com.example.demo.controller;

import com.example.demo.model.Orders;
import com.example.demo.model.OrdersItem;
import com.example.demo.service.OrdersItemService;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrdersItemService ordersItemService;

    @PostMapping
    public void insertOrders(@RequestBody Orders orders) {
        ordersService.insert(orders);
    }

    @GetMapping
    public List<Orders> getAllOrders(@RequestParam(required = false) String userId) {
        return ordersService.getAll();
    }

    @GetMapping("/{ordersId}")
    public Orders getOrders(@PathVariable Long ordersId) {
        return ordersService.getById(ordersId);
    }

    @DeleteMapping("/{ordersId}")
    public void deleteOrders(@PathVariable Long ordersId) {
        ordersService.deleteById(ordersId);
    }

    @PutMapping("/{ordersId}")
    public void updateOrders(@PathVariable Long ordersId, @RequestBody Orders orders) {
        ordersService.updateById(ordersId, orders);
    }


}