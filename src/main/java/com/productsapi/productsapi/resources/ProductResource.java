package com.productsapi.productsapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productsapi.productsapi.models.Product;
import com.productsapi.productsapi.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductResource {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> productList(){
		return productRepository.findAll();
	}
}