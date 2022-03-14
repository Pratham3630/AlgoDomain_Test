package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
public class MyController {
	@Autowired
	private ProductService productService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to product microservice";
	}

	// get product
	@GetMapping("/product")
	public List<Product> getProduct() {

		return this.productService.getProduct();
	}

	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable String productId) {
		return this.productService.getProduct(Long.parseLong(productId));
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {

		return this.productService.updateProduct(product);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId) {
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
