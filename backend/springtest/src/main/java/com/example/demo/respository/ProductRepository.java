package com.example.demo.respository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product as p inner join p.category as c " +
            "where (:categoryName is null or c.name = :categoryName)")
    public List<Product> getAll(String categoryName);

}