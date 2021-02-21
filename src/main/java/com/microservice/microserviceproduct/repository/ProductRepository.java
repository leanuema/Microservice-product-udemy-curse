package com.microservice.microserviceproduct.repository;

import com.microservice.microserviceproduct.products.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
