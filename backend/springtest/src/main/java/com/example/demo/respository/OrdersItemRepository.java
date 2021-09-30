package com.example.demo.respository;

import com.example.demo.model.OrdersItem;
import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItemRepository extends CrudRepository<OrdersItem, Long> { }