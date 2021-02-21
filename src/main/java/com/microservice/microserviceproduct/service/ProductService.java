package com.microservice.microserviceproduct.service;

import com.microservice.microserviceproduct.products.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    Product findById(Long id);
}
