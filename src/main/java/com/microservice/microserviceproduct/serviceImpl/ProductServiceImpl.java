package com.microservice.microserviceproduct.serviceImpl;

import com.microservice.microserviceproduct.products.Product;
import com.microservice.microserviceproduct.repository.ProductRepository;
import com.microservice.microserviceproduct.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
