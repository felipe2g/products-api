package com.productsapi.productsapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/products/{id}")
	public Product showOneProduct(@PathVariable(value="id") long id){
		//TODO - Try to use default function to find one.
		return productRepository.findById(id);
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		
		return productRepository.save(product);
		
	}
	
}
