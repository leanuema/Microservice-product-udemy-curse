package com.microservice.microserviceproduct.controller;

import com.microservice.microserviceproduct.products.Product;
import com.microservice.microserviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/listar")
    public List<Product> listar() {
        return productService.findAll();
    }

    @GetMapping("/obtener/{id}")
    public Product detalle(@PathVariable Long id) {
        return productService.findById(id);
    }
}
