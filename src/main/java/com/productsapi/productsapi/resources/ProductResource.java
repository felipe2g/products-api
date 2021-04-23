package com.productsapi.productsapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productsapi.productsapi.models.Product;
import com.productsapi.productsapi.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins="*")
public class ProductResource {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value="Return the list of all products.")
	public List<Product> productList(){
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	@ApiOperation(value="Return unique product.")
	public Product showOneProduct(@PathVariable(value="id") long id){
		//TODO - Try to use default function to find one.
		return productRepository.findById(id);
	}
	
	@PostMapping("/products")
	@ApiOperation(value="Save a product.")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/products")
	@ApiOperation(value="Delete a product.")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	
	//TODO - Use id in PathVariable to find product and change then.
	@PutMapping("/products")
	@ApiOperation(value="Change a product details.")
	public Product changeProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
