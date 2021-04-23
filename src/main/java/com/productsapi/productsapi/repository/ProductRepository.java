package com.productsapi.productsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsapi.productsapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findById(long id);
	
}
