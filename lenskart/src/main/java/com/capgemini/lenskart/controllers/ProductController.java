package com.capgemini.lenskart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.models.Product;
import com.capgemini.lenskart.models.dto.ProductUpdateDto;
import com.capgemini.lenskart.repository.ProductRepository;
import com.capgemini.lenskart.service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * This method will display all the products 
	 * 
	 * @return void
	 */

	@GetMapping(value = "/products")
	public ResponseEntity<Object> getAllProductDetails() {
		return new ResponseEntity<>(productService.getAllProductDetails(), HttpStatus.OK);
	}
	
	/**
	 * The method will search the particular product based on the input product id given by the user
	 * 
	 * @param productId
	 * @return display Product object of that particular id
	 */

	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
		return new ResponseEntity<>(productService.getByProductId(productId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allproducts")
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
		
	}
	
	/**
	 * The method will insert a product with its name in the database
	 * 
	 * @param product
	 * @return the inserted product object 
	 */

	@PostMapping(value = "/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
	}
	
	/**
	 * This method will delete the product object mapped with the given product id input
	 * 
	 * @param productId
	 * @return Show a success status after deleting the category successfully
	 */

	@DeleteMapping(value = "/deleteProduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * This method will delete all the product object present in the database
	 * 
	 * @param productId
	 * @return Show a success status after deleting all the product successfully from the database
	 */
	
	@DeleteMapping(value = "/deleteProduct")
	public ResponseEntity<Void> deleteProduct() {
		productService.deleteProduct();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * The method will update the product fields based on the given product id
	 * 
	 * @param productId
	 * @param productUpdateDto
	 * @return display the updated product fields
	 */

	@PutMapping(value = "/updateProduct/{productId}")
	public ResponseEntity<Object> updateProduct(@PathVariable("productId") Long productId,
			@RequestBody ProductUpdateDto productUpdateDto) {
		return new ResponseEntity<>(productService.updateProduct(productId, productUpdateDto), HttpStatus.OK);
	}

}
