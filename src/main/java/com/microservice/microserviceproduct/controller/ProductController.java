package com.microservice.microserviceproduct.controller;

import com.microservice.microserviceproduct.products.Product;
import com.microservice.microserviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Environment environment;
    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/listar")
    public List<Product> listar() {
        return productService.findAll().stream().map(product -> {
            //product.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
            product.setPort(port);
        return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/obtener/{id}")
    public Product obtener(@PathVariable Long id) {
        Product product= productService.findById(id);
        //product.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        product.setPort(port);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
