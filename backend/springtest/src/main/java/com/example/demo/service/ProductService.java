package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public Product getById(Long id) { return productRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)); }

    @Transactional
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }


    @Transactional
    public void updateById(Long Id, Product product) {
        Product existingProduct = productRepository.findById(Id).orElse(new Product());
        product.setId(existingProduct.getId());
        productRepository.save(product);
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
