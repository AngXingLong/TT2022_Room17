package com.example.demo.respository;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

    @Query("select o from Orders as o inner join o.user as u " +
            "where (:userId is null or u.id = :userId)")
    List<Orders> getAllOrders(Long userId);
}