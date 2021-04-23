package com.productsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
